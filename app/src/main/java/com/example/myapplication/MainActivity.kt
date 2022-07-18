package com.example.myapplication

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        cardNumUser.addTextChangedListener {

            if(it.toString().length>0){
                if (cardNumUser.text[0].digitToInt()<5){

                    cardInfo.setImageResource(R.drawable.master)

                }else{
                    cardInfo.setImageResource(R.drawable.visa)
                }
            }

            progressBar.progress=it.toString().length

            cardNum.text=cardNumUser.text
            if (it.toString().length==16){
                var nums=""
                var num=0
                for (i in it.toString()){
                    num++
                    nums=nums+i
                    if (num%4==0){

                        nums=nums+" "
                    }

                }
                cardNum.text=nums
            }

        }
        var mm=""
        var yy=""
        var date=""
        cardNameUser.addTextChangedListener{
            holderNameUser.text=cardNameUser.text.toString().uppercase()
        }
        expiryUser.addTextChangedListener {
            mm=it.toString()
            date=mm+"/"+yy
            expiryDateUser.text=date
        }
        expiryUser2.addTextChangedListener{
            yy=it.toString()
            date=mm+"/"+yy
            expiryDateUser.text=date

        }


    }
}