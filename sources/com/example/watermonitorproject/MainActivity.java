package com.example.watermonitorproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class MainActivity extends AppCompatActivity {
    EditText code;
    Button getcode;
    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
        }

        public void onVerificationFailed(FirebaseException e) {
        }

        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            MainActivity.super.onCodeSent(s, forceResendingToken);
            MainActivity.this.sentCode = s;
        }
    };
    EditText pnum;
    String sentCode;
    Button verify;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        MainActivity.super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.pnum = (EditText) findViewById(R.id.pnum);
        this.code = (EditText) findViewById(R.id.code);
        findViewById(R.id.getcode).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.sendVerificationCode();
            }
        });
        findViewById(R.id.verify).setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity.this.verifySentCode();
            }
        });
    }

    /* access modifiers changed from: private */
    public void verifySentCode() {
        signInWithPhoneAuthCredential(PhoneAuthProvider.getCredential(this.sentCode, this.code.getText().toString()));
    }

    /* JADX WARNING: type inference failed for: r2v0, types: [com.example.watermonitorproject.MainActivity, android.app.Activity] */
    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        this.mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            public void onComplete(Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Login Successfull", 1).show();
                    MainActivity.this.getSharedPreferences("choppu_data", 0).edit().putBoolean("is_logged_in", true).apply();
                    MainActivity.this.startActivity(new Intent(MainActivity.this.getApplicationContext(), NavigationActivity.class));
                } else if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                    Toast.makeText(MainActivity.this.getApplicationContext(), "Incorrect Verification Code ", 1).show();
                }
            }
        });
    }

    /* JADX WARNING: type inference failed for: r6v0, types: [android.app.Activity] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void sendVerificationCode() {
        /*
            r8 = this;
            android.widget.EditText r0 = r8.pnum
            android.text.Editable r0 = r0.getText()
            java.lang.String r0 = r0.toString()
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001d
            android.widget.EditText r1 = r8.pnum
            java.lang.String r2 = "Phone Number is required!"
            r1.setError(r2)
            android.widget.EditText r1 = r8.pnum
            r1.requestFocus()
            return
        L_0x001d:
            int r1 = r0.length()
            r2 = 10
            if (r1 >= r2) goto L_0x0032
            android.widget.EditText r1 = r8.pnum
            java.lang.String r2 = "Please enter a valid phone number!"
            r1.setError(r2)
            android.widget.EditText r1 = r8.pnum
            r1.requestFocus()
            return
        L_0x0032:
            com.google.firebase.auth.PhoneAuthProvider r1 = com.google.firebase.auth.PhoneAuthProvider.getInstance()
            r3 = 60
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.SECONDS
            com.google.firebase.auth.PhoneAuthProvider$OnVerificationStateChangedCallbacks r7 = r8.mCallbacks
            r2 = r0
            r6 = r8
            r1.verifyPhoneNumber(r2, r3, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.watermonitorproject.MainActivity.sendVerificationCode():void");
    }
}
