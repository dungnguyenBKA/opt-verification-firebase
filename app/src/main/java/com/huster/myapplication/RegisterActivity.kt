package com.huster.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.huster.myapplication.databinding.ActivityRegisterBinding


class RegisterActivity : AppCompatActivity() {
    companion object {
        @JvmStatic
        fun start(context: Context) {
            val starter = Intent(context, RegisterActivity::class.java)
            context.startActivity(starter)
        }
    }

    private lateinit var binding: ActivityRegisterBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSubmit.setOnClickListener {
            val phoneNumber = binding.edtMobilePhone.text.toString()
            if (phoneNumber.isValidPhoneNumber()) {
                VerifyOtpCodeActivity.start(this, phoneNumber)
            } else {
                Toast.makeText(this, "Số điện thoại có format không hợp lệ", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }
}


fun String.isValidPhoneNumber(): Boolean {
    return "^[+][0-9]{10,13}$".toRegex().matches(this)
}