
        package com.example.sendemail

        import android.content.Intent
                import android.os.Bundle
                import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation
                import android.widget.Button
                import android.widget.EditText
                import androidx.activity.enableEdgeToEdge
                import androidx.appcompat.app.AppCompatActivity
                import androidx.core.view.ViewCompat
                import androidx.core.view.WindowInsetsCompat

        class MainActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                enableEdgeToEdge()
                setContentView(R.layout.activity_main)
                val to:EditText=findViewById(R.id.to)
                val sub:EditText=findViewById(R.id.sub)
                val body:EditText=findViewById(R.id.body)
                val btn: Button =findViewById(R.id.button)
                btn.setOnClickListener(){
                    val email=to.text.toString()
                    val subject=sub.text.toString()
                    val msg=body.text.toString()
                    val intent=Intent(Intent.ACTION_SEND)
                    intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    intent.putExtra(Intent.EXTRA_SUBJECT,subject)
                    intent.putExtra(Intent.EXTRA_TEXT,msg)
                    intent.type="message/rfc822"
                    startActivity(Intent.createChooser(intent,"Choose a client ...!"))
                }
            }
        }
