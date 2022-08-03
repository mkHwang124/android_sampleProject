package com.example.myapplication.activity;

import static com.example.myapplication.common.CommonVariable.userAccountFileName;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void MyOnClick(View v)
    {
        try
        {
            switch (v.getId())
            {
                case R.id.btnLogin:
                    BtnLoginClick();
                    break;
                case R.id.txtJoin:
                    BtnJoinClick();
                    break;
            }
        }
        catch (Exception e)
        {
            System.out.println("MyOnClick Error");
            return;
        }
    }

    private void BtnLoginClick()
    {
        try
        {
            int startIndex = 0;
            int endIndex = 0;
            String temp = "";
            String fileContent = "";
            TextView tvId = (TextView)findViewById(R.id.txtId);
            TextView tvPw = (TextView)findViewById(R.id.txtPw);

            if (new File(getFilesDir() + userAccountFileName).exists())
            {
                InputStream iStream = new FileInputStream(getFilesDir() + userAccountFileName);
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(iStream));
                StringBuffer sBuffer = new StringBuffer();

                if (iStream != null)
                {
                    while((temp = bufferedReader.readLine()) != null)
                    {
                        sBuffer.append(temp);
                    }
                }
                bufferedReader.close();
                iStream.close();

                fileContent = sBuffer.toString();

                if (fileContent.contains(tvId.getText().toString()) == true)
                {
                    startIndex = fileContent.indexOf("\t", fileContent.indexOf(tvId.getText().toString()));
                    endIndex = fileContent.indexOf("\t", startIndex + 1);

                    if(tvPw.getText().toString().equals(fileContent.substring(startIndex+1, endIndex)))
                    {
                        Toast.makeText(this,"접속성공!", Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(this,"비밀번호를 확인해주세요!", Toast.LENGTH_LONG).show();
                    }
                }
                else
                {
                    Toast.makeText(this,"아이디를 확인해주세요!", Toast.LENGTH_LONG).show();
                }
            }


        }
        catch (Exception e)
        {
            System.out.println("BtnLoginClick Error");
            return;
        }
    }

    private void BtnJoinClick()
    {
        try
        {
            TextView tvId = (TextView)findViewById(R.id.txtId);
            TextView tvPw = (TextView)findViewById(R.id.txtPw);

            if (!new File(getFilesDir() + userAccountFileName).exists())
            {
                new File(getFilesDir() + userAccountFileName);
            }
            else
            {
                new File(getFilesDir() + userAccountFileName).delete();
                new File(getFilesDir() + userAccountFileName);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(getFilesDir() + userAccountFileName, true));
            bufferedWriter.write(tvId.getText().toString() + "\t");
            bufferedWriter.write(tvPw.getText().toString() + "\t\n");
            bufferedWriter.close();

            Toast.makeText(this,"회원가입이 완료되었습니다!", Toast.LENGTH_LONG).show();

//            Intent myIntent = new Intent(this, LayoutCodeActivity.class);
//            myIntent.putExtra("id",tvId.getText().toString());
//            myIntent.putExtra("pw",tvPw.getText().toString());
//            startActivity(myIntent);
        }
        catch (Exception e)
        {
            System.out.println("BtnJoinClick Error");
            return;
        }
    }
}