package com.example.snackbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class AlertDialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert_dialog)

        val btnShowAlertDialog = findViewById<Button>(R.id.btnShowAlertDialog)
        btnShowAlertDialog.setOnClickListener {
            /*val positiveButton = DialogInterface.OnClickListener { dialog, which ->
                Snackbar.make(
                    findViewById(R.id.btnShowAlertDialog),
                    "Saved $which",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            val negativeButton = DialogInterface.OnClickListener { dialog, which ->
                Snackbar.make(
                    findViewById(R.id.btnShowAlertDialog),
                    "Not Saved $which",
                    Snackbar.LENGTH_LONG
                ).show()
            }

            AlertDialog.Builder(this).also {
                it.setTitle("Save")
                it.setIcon(R.drawable.add_alert_24)
                it.setMessage("Are you sure to save?")

                it.setPositiveButton("Yes", positiveButton)
                it.setNegativeButton("No", negativeButton)
                it.setNeutralButton("Remind me later", null)

                it.setCancelable(false)
                it.show()
            }*/

            /*val options = arrayOf("First Item", "Second Item", "Third Item")
            val singleChoiceDialog = AlertDialog.Builder(this).apply {
                setTitle("Choose one of these options")
                setSingleChoiceItems(options, 1) { _, i ->
                    Toast.makeText(context, "You clicked on ${options[i]}", Toast.LENGTH_SHORT).show()
                }
                setPositiveButton("Accept") { _, _ ->
                    Toast.makeText(context, "You accepted the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
                }
                setNegativeButton("Decline") { _, _ ->
                    Toast.makeText(context, "You declined the SingleChoiceDialog", Toast.LENGTH_SHORT).show()
                }
            }
            singleChoiceDialog.show()*/


            /*val options = arrayOf("First Item", "Second Item", "Third Item")
            val multiChoiceDialog = AlertDialog.Builder(this).apply {
                setTitle("Choose one of these options")

                setMultiChoiceItems(
                    options,
                    booleanArrayOf(false, true, false)
                ) { _, i, isChecked ->
                    if (isChecked) {
                        Toast.makeText(context, "You checked ${options[i]}", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(context, "You unchecked ${options[i]}", Toast.LENGTH_SHORT)
                            .show()
                    }
                }

                setPositiveButton("Accept") { _, _ ->
                    Toast.makeText(
                        context,
                        "You accepted the MultiChoiceDialog",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                setNegativeButton("Decline") { _, _ ->
                    Toast.makeText(
                        context,
                        "You declined the MultiChoiceDialog",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
            multiChoiceDialog.show()*/

            AlertDialog.Builder(this).also {
                val customDialog = LayoutInflater.from(this).inflate(R.layout.custom_dialog, null)

                val dialogIcon = customDialog.findViewById<ImageView>(R.id.dialogIcon)
                dialogIcon.setImageResource(R.drawable.add_alert_24)

                val txtMessage = customDialog.findViewById<TextView>(R.id.txtMessage)
                txtMessage.text = "This is an Alert Dialog With an Icon"

                it.setView(customDialog)

                it.setNegativeButton("Cancel") { dialog, _ ->

                }

                it.show()
            }
        }
    }
}