import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.TargetDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
public class FileManager {
	private final static int RIFF_CHUNK_ID = 0x46464952;
	//1179011410
	public FileManager()							//2142143134
	{
		
		File soundFile = new File("src/bad0616.wav");
		byte[] riff = new byte[4];
		byte[] wave = new byte[4];
		try {
			FileInputStream fs = new FileInputStream(soundFile);
			fs.read(riff);
			fs.skip(4);
			fs.read(wave);
			
			if(FileManager.getLittleEndian(riff, 0, 4) == RIFF_CHUNK_ID)
			{
				System.out.println("Got RIFF");
			}
			
			String riffStr = new String(riff, 0, 4);
			String waveStr = new String(wave, 0, 4);
			
			System.out.println("Header: Riff?:"+riffStr+" Wave?:"+waveStr+" Test:"+(riff[0] & 0xFF));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static long getLittleEndian(byte[] arr, int offset, int numOfBytes)
	{
		numOfBytes--;//3
		int endIndex = offset+numOfBytes;//3
		long val = 0;
		if(endIndex>arr.length)
			return val;
		val = arr[endIndex] & 0xFF;
		for(int i=0; i<numOfBytes; i++)
		{
			val = (val << 8) + (arr[--endIndex] & 0xFF);
		}
		return val;
	}
	
//	public FileManager()
//	{
//		File soundFile = new File("src/bad0616.wav");
//		try {
//			byte[] header = new byte[400];
//			byte[] fileStreamHeader = new byte[400];
//			AudioInputStream as = AudioSystem.getAudioInputStream(soundFile);
//			System.out.println(AudioSystem.getAudioFileFormat(soundFile));
//			
//			FileInputStream fs = new FileInputStream(soundFile);
//			System.out.println(as.getFormat());
//			as.read(header);
//			fs.read(fileStreamHeader);
//			for(int i=0; i<header.length; i++)
//			{
//				String test = new String(header, i, 1);
//				System.out.println("AudioStream:"+test);
//			}
//			
//			for(int i=0; i<fileStreamHeader.length; i++)
//			{
//				String test = new String(fileStreamHeader, i, 1);
//				System.out.println("FileStream:"+test);
//			}
//			
////			int val;
////			while((val = as.read())!=-1)
////			{
////				System.out.println((char)val);
////			}
////			System.out.println((header[0]<<24) & 0xFF000000);
//			
//		} catch (UnsupportedAudioFileException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//	}
}
