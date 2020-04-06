package br.com.hover

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.annotation.RequiresApi
import br.com.hover.hover.overlay.OverlayPermission

class MainActivity : AppCompatActivity() {

    val REQUEST_CODE_HOVER_PERMISSION = 1000

    private var mPermissionsRequested = false
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var btnAlterarSenha = findViewById<Button>(R.id.button_launch_menu)

        btnAlterarSenha.setOnClickListener {
            V1HoverMenuService.showFloatingMenu(
                applicationContext
            )
        }

        if (!mPermissionsRequested && !OverlayPermission.hasRuntimePermissionToDrawOverlay(this)) {
            val myIntent = OverlayPermission.createIntentToRequestOverlayPermission(this)
            startActivityForResult(myIntent,REQUEST_CODE_HOVER_PERMISSION)
        }
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        if (REQUEST_CODE_HOVER_PERMISSION == requestCode) {
            mPermissionsRequested = true
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
