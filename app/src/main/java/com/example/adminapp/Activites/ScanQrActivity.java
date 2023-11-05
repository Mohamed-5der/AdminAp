package com.example.adminapp.Activites;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.Image;
import android.os.Bundle;
import android.util.Size;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.adminapp.R;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.mlkit.vision.barcode.BarcodeScanner;
import com.google.mlkit.vision.barcode.BarcodeScanning;
import com.google.mlkit.vision.barcode.common.Barcode;
import com.google.mlkit.vision.barcode.internal.BarcodeScannerImpl;
import com.google.mlkit.vision.common.InputImage;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ScanQrActivity extends AppCompatActivity {
  private EditText qrCodeEt;
  private PreviewView previewView;
  ImageButton back;

  private ListenableFuture<ProcessCameraProvider> cameraProviderListenableFuture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_qr);
        qrCodeEt=findViewById(R.id.et_qr_code);
        back=findViewById(R.id.btn_back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
        previewView=findViewById(R.id.cameraPreview);

        if(ContextCompat.checkSelfPermission(ScanQrActivity.this, Manifest.permission.CAMERA)== PackageManager.PERMISSION_GRANTED){

        }else{
            ActivityCompat.requestPermissions(ScanQrActivity.this,new String[]{Manifest.permission.CAMERA},101);
        }

    }
    public void init(){
        cameraProviderListenableFuture = ProcessCameraProvider.getInstance(ScanQrActivity.this);
        cameraProviderListenableFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {
                    ProcessCameraProvider cameraProvider =cameraProviderListenableFuture.get();
                   bindImageAnalysis(cameraProvider);
                } catch (ExecutionException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },ContextCompat.getMainExecutor(ScanQrActivity.this));
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(grantResults.length > 0 &&  grantResults[0] == PackageManager.PERMISSION_GRANTED){
            init();
        }else{
            Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void bindImageAnalysis(ProcessCameraProvider processCameraProvider){
        ImageAnalysis imageAnalysis =new ImageAnalysis.Builder().setTargetResolution(new Size(1200,720))
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST).build();

        imageAnalysis.setAnalyzer(ContextCompat.getMainExecutor(ScanQrActivity.this), new ImageAnalysis.Analyzer() {
            @Override
            public void analyze(@NonNull ImageProxy image) {
                Image mediaImage = image.getImage();
                if(mediaImage!=null){
                    InputImage image2 =InputImage.fromMediaImage(mediaImage,image.getImageInfo().getRotationDegrees());
                    BarcodeScanner scanner = BarcodeScanning.getClient();
                    Task<List<Barcode>> results = scanner.process(image2);
                    results.addOnSuccessListener(new OnSuccessListener<List<Barcode>>() {
                        @Override
                        public void onSuccess(List<Barcode> barcodes) {
                            for(Barcode barcode :barcodes){
                                final String getValue =barcode.getRawValue();
                                qrCodeEt.setText(getValue);
                            }
                            image.close();
                            mediaImage.close();

                        }
                    });

                }
            }
        });
        Preview preview =new Preview.Builder().build();
        CameraSelector cameraSelector =new CameraSelector.Builder().requireLensFacing(CameraSelector.LENS_FACING_BACK).build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());
        processCameraProvider.bindToLifecycle(this,cameraSelector,imageAnalysis,preview);
    }
}