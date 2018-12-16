package com.example.rafael.salvus;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.nfc.NdefMessage;
import android.nfc.NdefRecord;
import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.nio.charset.Charset;

import ferramentas.HttpUrlConnector;
import ferramentas.NfcTools;
import ferramentas.Tools;

@SuppressLint("LogNotTimber")
public class MainActivity extends AppCompatActivity {
    @Nullable private NfcAdapter nfcAdapter;
    private IntentFilter[] intentFiltersArray;
    private String[][] techListsArray;
    private PendingIntent pendingIntent;
    private Tag tag;
    private String cifra;
    private String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //NFC foreground dispatch
        nfcAdapter = NfcAdapter.getDefaultAdapter(this);
        pendingIntent = PendingIntent.getActivity(
                this, 0, new Intent(this, getClass()).addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP), 0);
        NfcTools.setNFCForegroundDispatch(intentFiltersArray, techListsArray);

        Button simularCartao = findViewById(R.id.simulate_card_button);

        simularCartao.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, OpcoesPacienteActivity.class);
                i.putExtra("token", token);
                startActivity(i);
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        String action = intent.getAction();
        Log.i("action", action);
        tag = intent.getParcelableExtra(NfcAdapter.EXTRA_TAG);
        Parcelable[] rawMessages = intent.getParcelableArrayExtra(NfcAdapter.EXTRA_NDEF_MESSAGES);
        if (rawMessages != null) {
            NdefMessage[] message = new NdefMessage[rawMessages.length];
            message[0] = (NdefMessage) rawMessages[0];

            final String idEtiqueta = Tools.bytesToHex(tag.getId());
            final String textoCifrado = new String(message[0].getRecords()[0].getPayload(), 0, message[0].getRecords()[0].getPayload().length, Charset.forName("UTF-8"));
            Log.i("cifra", textoCifrado);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        String resposta = HttpUrlConnector.sendGet("token/" + idEtiqueta + "," + textoCifrado);
                        String partes[] = resposta.split(",");
                        token = partes[0];
                        cifra = partes[1];
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });


            t.start();
            try {
                t.join();
                NdefRecord uriRecord1 = NdefRecord.createMime("text/plain", cifra.getBytes(Charset.forName("US-ASCII")));
                NdefRecord uriRecord2 = NdefRecord.createApplicationRecord("com.example.rafael.salvus");
                NfcTools.writeNdefMessageToTag(new NdefMessage(new NdefRecord[] { uriRecord1, uriRecord2 }), tag, getApplicationContext());
                Intent i = new Intent(this, OpcoesPacienteActivity.class);
                i.putExtra("token", token);
                startActivity(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void onPause() {
        super.onPause();
        if (nfcAdapter != null) {
            nfcAdapter.disableForegroundDispatch(this);
        }
    }

    public void onResume() {
        super.onResume();
        if (nfcAdapter != null) {
            nfcAdapter.enableForegroundDispatch(this, pendingIntent, intentFiltersArray, techListsArray);
        }
    }
}
