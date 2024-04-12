package com.weare2024.tonight.activites

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.weare2024.tonight.R
import com.weare2024.tonight.databinding.ActivityMyProfile1Binding

class MyProfileActivity1 : AppCompatActivity() {

    var gendera = ""
    private val binding by lazy { ActivityMyProfile1Binding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val man = findViewById<RadioButton>(R.id.man)
        val female = findViewById<RadioButton>(R.id.female)
        binding.btnNext1.setOnClickListener { clickNext() }

        val uid = intent.getStringExtra("kakao_uid")
        var nickname = intent.getStringExtra("nickname")
        if (nickname != null) {
            binding.tvGender.append(nickname)
        } else {
            Toast.makeText(this, "잘못됫습니다", Toast.LENGTH_SHORT).show()
        }


        binding.radioGroup.setOnCheckedChangeListener { group, checkedId ->

            when (checkedId) {
                R.id.man -> {
                    gendera = "남자"
                    female.isChecked = false
                }

                R.id.female -> {
                    gendera = "여자"
                    man.isChecked = false
                }
            }
        }



        overridePendingTransition(R.anim.from_right_enter_xml, R.anim.from_left_enter_xml)


        val intent2 = Intent(this, MyProfileActivity2::class.java)
//        intent2.putExtra("kakao_uid", uid)
//        intent2.putExtra("nickname", nickName)
//        intent2.putExtra("gender", gender)


    }

    fun clickNext() {

//        Log.d("ccc", gendera)
//        Log.d("nicnam",nickName.toString())
        if (intent.getStringExtra("kakao_uid") != null) {
            if (gendera == "남자") {
                val uid = intent.getStringExtra("kakao_uid")
                val nickname = intent.getStringExtra("nickname")
                val intent = Intent(this, MyProfileActivity2::class.java)
                val gender = "남자"
                intent.putExtra("gender", gender)
                intent.putExtra("kakao_uid", uid)
                intent.putExtra("nickname", nickname)
                startActivity(intent)

            } else if (gendera == "여자") {
                val uid = intent.getStringExtra("kakao_uid")
                val nickname = intent.getStringExtra("nickname")
                val intent = Intent(this, MyProfileActivity2::class.java)
                val gender = "여자"
                intent.putExtra("gender", gender)
                intent.putExtra("kakao_uid", uid)
                intent.putExtra("nickname", nickname)

                startActivity(intent)
            } else Toast.makeText(this, "성별을 선택해 주세요", Toast.LENGTH_SHORT).show()
        }
        else if (intent.getStringExtra("google_uid") != null) {
            if (gendera == "남자") {
                val uid = intent.getStringExtra("google_uid")
                val nickname = intent.getStringExtra("nickname")
                val intent = Intent(this, MyProfileActivity2::class.java)
                val gender = "남자"
                intent.putExtra("gender", gender)
                intent.putExtra("google_uid", uid)
                intent.putExtra("nickname", nickname)
                startActivity(intent)

            } else if (gendera == "여자") {
                val uid = intent.getStringExtra("google_uid")
                val nickname = intent.getStringExtra("nickname")
                val intent = Intent(this, MyProfileActivity2::class.java)
                val gender = "여자"
                intent.putExtra("gender", gender)
                intent.putExtra("google_uid", uid)
                intent.putExtra("nickname", nickname)
                startActivity(intent)
            } else Toast.makeText(this, "성별을 선택해 주세요", Toast.LENGTH_SHORT).show()
        }
    }
}
