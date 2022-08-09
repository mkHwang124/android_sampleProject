package com.example.myapplication.activity;

import static com.example.myapplication.common.CommonVariable.userAccountFileName;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class JoinActivity extends AppCompatActivity {

    String userId;
    String userPw;
    String userDataFile;

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        try
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            Intent myIntent = getIntent();
            userId = myIntent.getStringExtra("userId");
            userPw = myIntent.getStringExtra("userPw");

            TextView txtId = (TextView) findViewById(R.id.txtId);
            TextView txtPw = (TextView) findViewById(R.id.txtPw);

            if ( userId != null && userId.length() != 0 )
            {
                txtId.setText(userId);
            }

            if ( userPw != null && userPw.length() != 0 )
            {
                txtPw.setText(userPw);
            }

            userDataFile = getFilesDir() + userAccountFileName;
        }
        catch (Exception e)
        {
            System.out.println("OnCreate Error");
            return;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case android.R.id.home:
            {
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }

    public void MyOnClick(View v)
    {
        try
        {
            switch (v.getId())
            {
                case R.id.btnCheck:
                    BtnCheckClick();
                    break;
                case R.id.btnMail:
                    BtnMailClick();
                    break;
                case R.id.btnJoin:
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

    private boolean BtnCheckClick()
    {
        try
        {
            String userPw = "";
            String userPwCheck = "";

            TextView txtPw = (TextView) findViewById(R.id.txtPw);
            TextView txtPwCheck = (TextView) findViewById(R.id.txtPwCheck);

            userPw = txtPw.getText().toString();
            userPwCheck = txtPwCheck.getText().toString();

            if (!userPw.equals(userPwCheck))
            {
                Toast.makeText(this, "비밀번호를 확인해주세요.", Toast.LENGTH_LONG).show();
                return false;
            }
            else
            {
                Toast.makeText(this, "비밀번호가 일치합니다.", Toast.LENGTH_LONG).show();
                return true;
            }
        }
        catch (Exception e)
        {
            System.out.println("BtnCheckClick Error");
            return false;
        }
    }

    private void BtnMailClick()
    {
        try
        {
            Toast.makeText(this, "BtnMailClick", Toast.LENGTH_LONG).show();
        }
        catch (Exception e)
        {
            System.out.println("BtnMailClick Error");
            return;
        }
    }

    private void BtnJoinClick()
    {
        try
        {
            if(!BtnCheckClick())
            {
                return;
            }

            TextView txtId = (TextView) findViewById(R.id.txtId);
            TextView txtPw = (TextView) findViewById(R.id.txtPw);
            TextView txtName = (TextView) findViewById(R.id.txtName);
            TextView txtYear = (TextView) findViewById(R.id.txtYear);
            TextView txtMonth = (TextView) findViewById(R.id.txtMonth);
            TextView txtDay = (TextView) findViewById(R.id.txtDay);
            TextView txtMail = (TextView) findViewById(R.id.txtMail);

            if (!new File(userDataFile).exists()) {
                new File(userDataFile);
            }

            BufferedWriter bufferedWriter = new BufferedWriter(
                    new FileWriter(userDataFile, true));
            if (txtId.getText() != null && txtId.getText().length() > 0)
            bufferedWriter.write(txtId.getText().toString() + "\t");
            if (txtPw.getText() != null && txtPw.getText().length() > 0)
            bufferedWriter.write(txtPw.getText().toString() + "\t");
            if (txtName.getText() != null && txtName.getText().length() > 0)
            bufferedWriter.write(txtName.getText().toString() + "\t");
            if (txtYear.getText() != null && txtYear.getText().length() > 0)
            bufferedWriter.write(txtYear.getText().toString() + "\t");
            if (txtMonth.getText() != null && txtMonth.getText().length() > 0)
            bufferedWriter.write(txtMonth.getText().toString() + "\t");
            if (txtDay.getText() != null && txtDay.getText().length() > 0)
            bufferedWriter.write(txtDay.getText().toString() + "\t");
            if (txtMail.getText() != null && txtMail.getText().length() > 0)
            bufferedWriter.write(txtMail.getText().toString() + "\t");
            bufferedWriter.write("\n");
            bufferedWriter.close();

            Toast.makeText(this,"회원가입이 완료되었습니다!", Toast.LENGTH_LONG).show();

            Intent myIntent = new Intent(JoinActivity.this, LoginActivity.class);

            if (txtId.getText() != null && txtId.getText().length() > 0)
            myIntent.putExtra("userID", txtId.getText().toString());

            setResult(RESULT_OK);
            finish();

        }
        catch (Exception e)
        {
            System.out.println("BtnJoinClick Error");
            return;
        }
    }
}