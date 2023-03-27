package com.example.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.intent.MainActivity.Constantes.PARAMETRO_EXTRA
import com.example.intent.databinding.ActivityParametroBinding

class ParametroActivity : AppCompatActivity() {

    private val apb: ActivityParametroBinding by lazy {
        ActivityParametroBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(apb.root)
        intent.getStringExtra(PARAMETRO_EXTRA)?.let { parametro ->
            apb.parametroEt.setText(parametro)
        }
        /* Uma maneira alternativa de fazer:
        parametro: String = intent.getStringExtra(PARAMETRO_EXTRA)
        if (parametro != null) {
            apb.parametroEt.setText(parametro)
        }
         */

        apb.enviarParametroBt.setOnClickListener {
            val parametro: String = apb.parametroEt.text.toString()
            val retornoIntent: Intent = Intent()
            retornoIntent.putExtra(PARAMETRO_EXTRA, parametro)
            setResult(RESULT_OK, retornoIntent)
            finish()
        }
    }
}