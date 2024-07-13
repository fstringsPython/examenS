package com.cursokotlin.examens

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cursokotlin.examens.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var vBind: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        vBind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vBind.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        vBind.botonIngresar.setOnClickListener { transaccion() }
        vBind.botonRetirar.setOnClickListener { transaccion() }

    }

    fun transaccion(){

        var saldo = 0
        vBind.saldoC.setText(saldo.toString())

        val ingresarRetirar = vBind.ingresoValor.text.toString().toInt()

        if (vBind.botonIngresar.isClickable == true){
            var nuevoSaldo = saldo + ingresarRetirar
            vBind.saldoC.setText(nuevoSaldo.toString())
            if (nuevoSaldo == 0 && vBind.botonRetirar.isClickable == true){
                val aviso = "El saldo en su cuenta es 0 dólares"
                vBind.aviso.setText(aviso)
            }
            if (nuevoSaldo > 0 && ingresarRetirar < nuevoSaldo){
                if (vBind.botonRetirar.isClickable == true){
                    nuevoSaldo = nuevoSaldo - ingresarRetirar
                    vBind.saldoC.setText(nuevoSaldo.toString())
                }
            }

        }


    }

}
