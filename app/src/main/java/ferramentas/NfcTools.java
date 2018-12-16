package ferramentas;

import android.content.Context;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.tech.Ndef;
import android.nfc.tech.NdefFormatable;
import android.util.Log;
import android.widget.Toast;

import java.io.IOException;
import java.nio.charset.Charset;

import javax.crypto.SecretKey;

/**
 * Created by Rafael on 06/07/2016.
 */
public class NfcTools {

    public static boolean writeNdefMessageToTag(NdefMessage message, Tag detectedTag, Context context) {
        int size = message.toByteArray().length;
        try {
            Ndef ndef = Ndef.get(detectedTag);
            if (ndef != null) {
                ndef.connect();
                if (!ndef.isWritable()) {
                    Toast.makeText(context, "Etiqueta somente leitura", Toast.LENGTH_SHORT).show();
                    return false;
                }
                if (ndef.getMaxSize() < size) {
                    Toast.makeText(context, "Mensagem (" + size + " bytes) maior que a capacidade da etiqueta (" + ndef.getMaxSize() + " bytes)", Toast.LENGTH_SHORT).show();
                    return false;
                }
                ndef.writeNdefMessage(message);
                ndef.close();
                Toast.makeText(context, "Wrote " + size + " bytes!", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                NdefFormatable ndefFormat = NdefFormatable.get(detectedTag);
                if (ndefFormat != null) {
                    try {
                        ndefFormat.connect();
                        ndefFormat.format(message);
                        ndefFormat.close();
                        Toast.makeText(context, "Wrote " + size + " bytes!", Toast.LENGTH_SHORT).show();
                    } catch (IOException e) {
                        Toast.makeText(context, "Falha para formatar etiqueta", Toast.LENGTH_SHORT).show();
                        return false;
                    }
                } else {
                    Toast.makeText(context, "Formato NDEF não suportado", Toast.LENGTH_SHORT).show();
                }
            }
        } catch (Exception e) {
            Toast.makeText(context, "Writing failed!", Toast.LENGTH_SHORT).show();
            Log.e("Protectouch", "exception", e);
        }
        return false;
    }
    public static void setNFCForegroundDispatch(IntentFilter[] intentFiltersArray, String[][] techListsArray){
        IntentFilter ndef = new IntentFilter(NfcAdapter.ACTION_NDEF_DISCOVERED);
        IntentFilter tech = new IntentFilter(NfcAdapter.ACTION_TECH_DISCOVERED);
        IntentFilter tag = new IntentFilter(NfcAdapter.ACTION_TAG_DISCOVERED);
        try {
            ndef.addDataType("*/*");    // Handles MIME based dispatches
        }
        catch (IntentFilter.MalformedMimeTypeException e) {
            throw new RuntimeException("fail", e);
        }
        intentFiltersArray = new IntentFilter[] {ndef, tech, tag };
        techListsArray = new String[][] { new String[] {
                Ndef.class.getName(),
        } };
    }

}
