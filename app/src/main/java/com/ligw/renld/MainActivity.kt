package com.ligw.renld

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.media.session.PlaybackState
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.DocumentsContract
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.ligw.renld.adapter.MainAdapter
import com.ligw.renld.databinding.ActivityMainBinding
import com.ligw.renld.entity.MainData
import com.tbruyelle.rxpermissions3.RxPermissions
import io.reactivex.rxjava3.functions.Consumer
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var _bind: ActivityMainBinding

    lateinit var mainAdapter: MainAdapter

    lateinit var launcher: ActivityResultLauncher<Intent>

    var list: MutableList<MainData> = mutableListOf()

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _bind = DataBindingUtil.setContentView(this, R.layout.activity_main)

        list.add(MainData("文件", "您的文件应用程序", android.R.drawable.ic_menu_rotate))
        list.add(MainData("历史", "浏览已转换文件  ", android.R.drawable.ic_menu_rotate))
        mainAdapter = MainAdapter(this, list)
        _bind.rvList.layoutManager = GridLayoutManager(this, 2)
        _bind.rvList.adapter = mainAdapter

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            //此处使用lambda表达式，是第二个参数ActivityResultCallback的实现
            if (it.resultCode == RESULT_OK) {
                Toast.makeText(this, it.data?.data.toString(), Toast.LENGTH_SHORT).show()
                Toast.makeText(this, it.data?.data?.path, Toast.LENGTH_SHORT).show()
            } else {

            }
        }
    }

    fun startPage(position: Int) {
        when(position){
            0->{
                goFiles()
            }
            else->{
                Toast.makeText(this,"正在开发中",Toast.LENGTH_SHORT).show()
            }
        }
    }

    /**
     * 打开文件夹
     */
    fun goFiles(){
        var rxPermission = RxPermissions(this)
        rxPermission.request(Manifest.permission.READ_EXTERNAL_STORAGE)
            .subscribe {
                if (it) {
                    val uri: Uri =
                        Uri.parse("content://com.android.externalstorage.documents/document/")
                    val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                        addCategory(Intent.CATEGORY_OPENABLE)
                        type = "*/*"
                        //DocumentsContract.EXTRA_INITIAL_URI
                        putExtra(Intent.ACTION_OPEN_DOCUMENT, uri)
                    }
                    launcher.launch(intent)
                } else {
                    Toast.makeText(this, "需要权限才能继续", Toast.LENGTH_SHORT).show()
                }
            }
    }


}