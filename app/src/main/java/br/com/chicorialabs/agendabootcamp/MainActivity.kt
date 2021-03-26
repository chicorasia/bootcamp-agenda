package br.com.chicorialabs.agendabootcamp

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.CalendarContract.Events.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import br.com.chicorialabs.agendabootcamp.databinding.ActivityMainBinding
import java.math.BigDecimal


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initBtn()
        initBtnAddAttendee()

    }

    private fun initBtnAddAttendee() {
        binding.addAttendeeBtn.setOnClickListener {
            adicionaParticipante()
        }
    }

    internal fun initBtn() {
        binding.setEventBtn.setOnClickListener {

            val intent = Intent(Intent.ACTION_INSERT)
                    .setData(CONTENT_URI)
                    .putExtra(TITLE, "Live de Kotlin 2222")
                    .putExtra(EVENT_LOCATION, "Chicória Labs")


            startActivity(intent)

        }
    }

    fun adicionaParticipante() {

        val intent = Intent(Intent.ACTION_EDIT)
            .setData(CONTENT_URI)
            .putExtra(CalendarContract.Events.HAS_ATTENDEE_DATA, "1")


    }

//    fun adicionaParticipante() {
//        val projection = arrayOf(CalendarContract.Calendars._ID)
//        val cursor = contentResolver.query(CONTENT_URI, projection, null, null, null)
//        if (cursor?.moveToLast() == true) {
//            val lastId = cursor.getLong(0)
//            lastId.let {
//                val value = ContentValues().apply {
//                    put(CalendarContract.Attendees.ATTENDEE_NAME, "Chico Rasia")
//                    put(CalendarContract.Attendees.ATTENDEE_EMAIL, "contato@chicoria.com")
//                    put(CalendarContract.Attendees.EVENT_ID, it)
//                }
//                contentResolver.insert(CalendarContract.Attendees.CONTENT_URI, value)
//            }
//
//        }
//    }

}