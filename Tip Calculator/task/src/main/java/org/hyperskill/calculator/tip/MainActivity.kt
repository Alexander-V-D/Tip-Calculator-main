package org.hyperskill.calculator.tip

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.slider.Slider
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<EditText>(R.id.edit_text).addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
            override fun afterTextChanged(s: Editable?) {
                if (edit_text.text.toString() == "") {
                    text_view.text = ""
                } else text_view.text = "Tip amount: ${tipAmount()}"

            }
        })
        findViewById<Slider>(R.id.slider).addOnChangeListener(object: Slider.OnChangeListener {
            override fun onValueChange(slider: Slider, value: Float, fromUser: Boolean) {
                if (edit_text.text.toString() == "") {
                    text_view.text = ""
                } else text_view.text = "Tip amount: ${tipAmount()}"
            }
        })

        }
    fun tipAmount(): BigDecimal {
        val tip = BigDecimal(slider.value.toString()).setScale(2, RoundingMode.HALF_EVEN)
        val number = BigDecimal(edit_text.text.toString()).setScale(2, RoundingMode.HALF_EVEN)
        val deviser = BigDecimal(100).setScale(2, RoundingMode.HALF_EVEN)
        val result = number * tip / deviser
        return(result.setScale(2, RoundingMode.HALF_EVEN))
    }
    }


