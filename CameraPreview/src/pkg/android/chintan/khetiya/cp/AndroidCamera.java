package pkg.android.chintan.khetiya.cp;

import java.io.IOException;

import android.app.Activity;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class AndroidCamera extends Activity implements SurfaceHolder.Callback
	{

		Camera camera;
		SurfaceView surfaceView;
		SurfaceHolder surfaceHolder;
		Button buttonStartCameraPreview, buttonStopCameraPreview;
		boolean previewing = false;
		LinearLayout get_more;

		/** Called when the activity is first created. */
		@Override
		public void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				setContentView(R.layout.main);

				buttonStartCameraPreview = (Button) findViewById(R.id.startcamerapreview);
				buttonStopCameraPreview = (Button) findViewById(R.id.stopcamerapreview);

				surfaceView = (SurfaceView) findViewById(R.id.surfaceview);
				get_more = (LinearLayout) findViewById(R.id.get_more);
				surfaceHolder = surfaceView.getHolder();
				surfaceHolder.addCallback(this);
				surfaceHolder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);

				buttonStartCameraPreview.setOnClickListener(new OnClickListener()
					{

						@Override
						public void onClick(View v)
							{
								// TODO Auto-generated method stub
								if (!previewing)
									{
										camera = Camera.open();
										if (camera != null)
											{
												try
													{
														camera.setPreviewDisplay(surfaceHolder);
														camera.startPreview();
														previewing = true;
													} catch (IOException e)
													{
														// TODO Auto-generated catch block
														e.printStackTrace();
													}
											}
									}

							}
					});
				buttonStopCameraPreview.setOnClickListener(new OnClickListener()
					{

						@Override
						public void onClick(View v)
							{
								// TODO Auto-generated method stub
								if (camera != null && previewing)
									{
										camera.stopPreview();
										camera.release();
										camera = null;
										previewing = false;
									}

							}
					});
				get_more.setOnClickListener(new OnClickListener()
					{

						@Override
						public void onClick(View v)
							{
								// TODO Auto-generated method stub
								Intent intent = new Intent(AndroidCamera.this, My_Blog.class);
								startActivity(intent);

							}
					});

			}

		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void surfaceCreated(SurfaceHolder holder)
			{
				// TODO Auto-generated method stub

			}

		@Override
		public void surfaceDestroyed(SurfaceHolder holder)
			{
				// TODO Auto-generated method stub

			}

	}

/*
 * chintan Dec 25, 2013 AndroidCamera.java
 */