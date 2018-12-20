package com.example.javier.pdfdocument;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private String[]header={"Id", "Nombre", "Apellido"};
    private String shortText = "Hola";
    private String longText = "En un lugar de La Mancha, de cuyo nombre no quiero acordarme no ha mucho tiempo vivía un caballero...";
    private TemplatePDF templatePDF;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);

        templatePDF = new TemplatePDF(getApplicationContext());
        templatePDF.openDocument();
        templatePDF.addMetaData("Clientes", "Ventas", "Javier");
        templatePDF.addTitles("Tienda CodigoFacilito", "Clientes", "20/12/2018");
        templatePDF.addParagraph(shortText);
        templatePDF.addParagraph(longText);
        templatePDF.createTable(header, getClientes());
        templatePDF.closeDocument();

        button.setOnClickListener(this);
    }

    public void pdfView(){
        templatePDF.viewPDF();
    }



    private ArrayList<String[]>getClientes(){
        ArrayList<String[]> rows = new ArrayList<>();

        rows.add(new String[]{"1", "Pedro", "Lopez"});
        rows.add(new String[]{"2", "Jose", "Perez"});
        rows.add(new String[]{"3", "Alberto", "Piña"});
        rows.add(new String[]{"4", "Raúl", "González"});
        rows.add(new String[]{"5", "Pedro", "Picapiedra"});
        return rows;
    }


    @Override
    public void onClick(View v) {
        pdfView();
    }
}
