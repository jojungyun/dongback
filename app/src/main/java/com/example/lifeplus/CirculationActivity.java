package com.example.lifeplus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class CirculationActivity extends AppCompatActivity {

    ListView list_excel;

    ArrayList<HashMap<String, String>> list = new ArrayList<>();
    HashMap<String, String> item = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulation);

        list_excel = (ListView)findViewById(R.id.list_excel);

        circulation_list();

        SimpleAdapter adapter = new SimpleAdapter(this, list, android.R.layout.simple_list_item_2,
                new String[]{"name", "location"},
                new int[]{android.R.id.text1, android.R.id.text2});

        list_excel.setAdapter(adapter);
    }
        public void circulation_list() {
        try {
            // File read
            InputStream is = getBaseContext().getResources().getAssets().open("Gaya_Test.xls");
            // Excel file
            Workbook wb = Workbook.getWorkbook(is);

            // Workbook is not null
            if (wb != null) {
                Sheet sheet = wb.getSheet(0);
                // sheet is not null
                if (sheet != null) {
                    int colTotal = sheet.getColumns();
                    int rowIndexStart = 0;
                    int rowTotal = sheet.getColumn(colTotal - 1).length;

                    for (int row = rowIndexStart; row < rowTotal; row++) {
                        String category = sheet.getCell(2, row).getContents();

                        switch (category) {
                            case "유통" :
                                String name = sheet.getCell(0, row).getContents();
                                item.put("name", name);
                                String location = sheet.getCell(1, row).getContents();
                                item.put("location", location);
                                list.add(item);

                                System.out.println(item);

                                item = new HashMap<>();
                        }
                    }
                }
            }
        }catch (IOException e) {
            e.printStackTrace();
        }catch (BiffException e) {
            e.printStackTrace();
        }
    }
}