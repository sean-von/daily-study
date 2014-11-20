package com.smikevon.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class TestFileChannel {

	public static void main(String[] args) throws IOException {

		RandomAccessFile file = new RandomAccessFile("/home/fengxiao/sql/yeepay1", "rw");

		FileChannel chennel = file.getChannel();
		ByteBuffer buffer = ByteBuffer.allocate(48);

		int bytesRead = chennel.read(buffer);

		while(bytesRead != -1){
			System.out.println("Read "+bytesRead);
			System.out.println(buffer);
			buffer.flip();//设置limit=position position=0
			System.out.println(buffer);
			while (buffer.hasRemaining()) {
				System.out.println((char)buffer.get());
			}

			buffer.clear();

			bytesRead = chennel.read(buffer);

		}

		file.close();
	}

}
