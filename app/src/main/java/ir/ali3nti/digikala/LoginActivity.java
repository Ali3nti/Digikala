package ir.ali3nti.digikala;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

  CheckBox showPass;
  EditText edt_phone, edt_password;
  TextView txt_showPass, txt_signUp;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    showPass = (CheckBox) findViewById(R.id.ckb_showpass);
    edt_phone = (EditText)findViewById(R.id.edt_phone);
    edt_password = (EditText)findViewById(R.id.edt_password);
    txt_showPass = (TextView) findViewById(R.id.txt_showPass);
    txt_signUp = (TextView) findViewById(R.id.txt_signUp);




    showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
      @Override
      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        passwordChangeType(isChecked);
      }
    });

    txt_showPass.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        if(showPass.isChecked())
          showPass.setChecked(false);
        else
          showPass.setChecked(true);
      }
    });

    txt_signUp.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {

        Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
        startActivity(intent);
        finish();
      }
    });
  }


  public void passwordChangeType (boolean isChecked) {

    int start, end;

    if (!isChecked) {
      start = edt_password.getSelectionStart();
      end = edt_password.getSelectionEnd();
      edt_password.setTransformationMethod(new PasswordTransformationMethod());
      edt_password.setSelection(start, end);
    } else {
      start = edt_password.getSelectionStart();
      end = edt_password.getSelectionEnd();
      edt_password.setTransformationMethod(null);
      edt_password.setSelection(start, end);
    }
  }
}