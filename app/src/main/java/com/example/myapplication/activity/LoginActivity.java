package com.example.myapplication.activity;

import static com.example.myapplication.common.CommonVariable.userAccountFileName;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.R;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity {

    String userDataFile;

    // launcher 선언
    ActivityResultLauncher<Intent> launcher = registerForActivityResult
            (new ActivityResultContracts.StartActivityForResult(),
    result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
//            String userId = "";
            Intent data = result.getData();
//            userId = data.getStringExtra("userId");
//
//            TextView txtId = (TextView) findViewById(R.id.txtId);
//            txtId.setText(userId);
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        try
        {
            userDataFile = getFilesDir() + userAccountFileName;
        }
        catch (Exception e)
        {
            System.out.println("OnCreate Error");
            return;
        }

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

    //로그인버튼 클릭 이벤트
    private void BtnLoginClick()
    {
        try
        {
            int startIndex = 0;
            int endIndex = 0;
            String temp = "";
            String fileContent = "";
            String userId = "";
            String userPw = "";

            TextView tvId = (TextView)findViewById(R.id.txtId);
            TextView tvPw = (TextView)findViewById(R.id.txtPw);
            userId = tvId.getText().toString();
            userPw = tvPw.getText().toString();

            if (new File(userDataFile).exists() && userId != null && userId.length() > 0 &&
                    userPw != null && userPw.length() > 0)
            {
                InputStream iStream = new FileInputStream(userDataFile);
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

                if (fileContent.contains(userId + "\t") == true)
                {
                    startIndex = fileContent.indexOf("\t", fileContent.indexOf(userId + "\t"));
                    endIndex = fileContent.indexOf("\t", startIndex + 1);

                    if(userPw.equals(fileContent.substring(startIndex+1, endIndex)))
                    {
                        Toast.makeText(this,"접속성공!", Toast.LENGTH_LONG).show();

                        Intent myIntent = new Intent(this, MainActivity.class);
                        myIntent.putExtra("userId",tvId.getText().toString());
                        startActivity(myIntent);
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

    //회원가입 버튼 클릭 이벤트
    private void BtnJoinClick()
    {
        try
        {
            TextView tvId = (TextView)findViewById(R.id.txtId);
            TextView tvPw = (TextView)findViewById(R.id.txtPw);

            Intent myIntent = new Intent(this, JoinActivity.class);
            myIntent.putExtra("userId",tvId.getText().toString());
            myIntent.putExtra("userPw",tvPw.getText().toString());
            launcher.launch(myIntent);
        }
        catch (Exception e)
        {
            System.out.println("BtnJoinClick Error");
            return;
        }
    }
}