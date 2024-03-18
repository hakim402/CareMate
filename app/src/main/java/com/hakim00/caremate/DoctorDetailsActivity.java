package com.hakim00.caremate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][]doctor_details1 =
            {
                    {"Doctor Name : Mohammad Ali", "Hospital Address : Karti Chahar kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "600" },
                    {"Doctor Name : Mohammad Yousuf", "Hospital Address : Karti Now kabul", "Exp : 6yr", "Mobile Number : +93 000000000", "800" },
                    {"Doctor Name : Mohammad Omar", "Hospital Address : Shahrenow kabul", "Exp : 7yr", "Mobile Number : +93 000000000", "1000" },
                    {"Doctor Name : Abdul Malik", "Hospital Address : Dehmazang kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "900" },
                    {"Doctor Name : Mohammad Buner", "Hospital Address : Ahmad Shah Baba Mena kabul", "Exp : 3yr", "Mobile Number : +93 000000000", "700" }
            };
    private String [][]doctor_details2 =
            {
                    {"Doctor Name : Mohammad Ali", "Hospital Address : Karti Chahar kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "600" },
                    {"Doctor Name : Mohammad Yousuf", "Hospital Address : Karti Now kabul", "Exp : 6yr", "Mobile Number : +93 000000000", "800" },
                    {"Doctor Name : Mohammad Omar", "Hospital Address : Shahrenow kabul", "Exp : 7yr", "Mobile Number : +93 000000000", "1000" },
                    {"Doctor Name : Abdul Malik", "Hospital Address : Dehmazang kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "900" },
                    {"Doctor Name : Mohammad Buner", "Hospital Address : Ahmad Shah Baba Mena kabul", "Exp : 3yr", "Mobile Number : +93 000000000", "700" }
            };
    private String [][]doctor_details3 =
            {
                    {"Doctor Name : Mohammad Ali", "Hospital Address : Karti Chahar kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "600" },
                    {"Doctor Name : Mohammad Yousuf", "Hospital Address : Karti Now kabul", "Exp : 6yr", "Mobile Number : +93 000000000", "800" },
                    {"Doctor Name : Mohammad Omar", "Hospital Address : Shahrenow kabul", "Exp : 7yr", "Mobile Number : +93 000000000", "1000" },
                    {"Doctor Name : Abdul Malik", "Hospital Address : Dehmazang kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "900" },
                    {"Doctor Name : Mohammad Buner", "Hospital Address : Ahmad Shah Baba Mena kabul", "Exp : 3yr", "Mobile Number : +93 000000000", "700" }
            };
    private String [][]doctor_details4 =
            {
                    {"Doctor Name : Mohammad Ali", "Hospital Address : Karti Chahar kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "600" },
                    {"Doctor Name : Mohammad Yousuf", "Hospital Address : Karti Now kabul", "Exp : 6yr", "Mobile Number : +93 000000000", "800" },
                    {"Doctor Name : Mohammad Omar", "Hospital Address : Shahrenow kabul", "Exp : 7yr", "Mobile Number : +93 000000000", "1000" },
                    {"Doctor Name : Abdul Malik", "Hospital Address : Dehmazang kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "900" },
                    {"Doctor Name : Mohammad Buner", "Hospital Address : Ahmad Shah Baba Mena kabul", "Exp : 3yr", "Mobile Number : +93 000000000", "700" }
            };
    private String [][]doctor_details5 =
            {
                    {"Doctor Name : Mohammad Ali", "Hospital Address : Karti Chahar kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "600" },
                    {"Doctor Name : Mohammad Yousuf", "Hospital Address : Karti Now kabul", "Exp : 6yr", "Mobile Number : +93 000000000", "800" },
                    {"Doctor Name : Mohammad Omar", "Hospital Address : Shahrenow kabul", "Exp : 7yr", "Mobile Number : +93 000000000", "1000" },
                    {"Doctor Name : Abdul Malik", "Hospital Address : Dehmazang kabul", "Exp : 5yr", "Mobile Number : +93 000000000", "900" },
                    {"Doctor Name : Mohammad Buner", "Hospital Address : Ahmad Shah Baba Mena kabul", "Exp : 3yr", "Mobile Number : +93 000000000", "700" }
            };
    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    HashMap<String, String> item;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        ArrayList list;
        SimpleAdapter sa;



        if(title.compareTo("Family Physicians")==0)
            doctor_details = doctor_details1;
        else
        if(title.compareTo("Dietician")==0)
            doctor_details = doctor_details2;
        else
        if(title.compareTo("Dentist")==0)
            doctor_details = doctor_details3;
        else
        if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else
            doctor_details = doctor_details5;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class));
            }
        });
        list = new ArrayList();
        for(int x = 0; x < doctor_details.length; x++){
            item = new HashMap<String, String>();
            item.put("line1", doctor_details[x][0]);
            item.put("line2", doctor_details[x][1]);
            item.put("line3", doctor_details[x][2]);
            item.put("line4", doctor_details[x][3]);
            item.put("line5", "Cons Fees:"+doctor_details[x][4]+"/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
                );
        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);
    }
}