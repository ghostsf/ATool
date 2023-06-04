package com.ghostsf.atool.io;

import java.nio.file.Path;
import java.nio.file.WatchEvent;

import com.ghostsf.atool.io.watch.SimpleWatcher;
import com.ghostsf.atool.io.watch.WatchMonitor;
import com.ghostsf.atool.io.watch.Watcher;
import com.ghostsf.atool.io.watch.watchers.DelayWatcher;
import com.ghostsf.atool.lang.Console;

/**
 * 文件监听单元测试
 * 
 * @author ghostsf
 *
 */
public class WatchMonitorTest {

	public static void main(String[] args) {
		Watcher watcher = new SimpleWatcher(){
			@Override
			public void onCreate(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("创建：{}-> {}", currentPath, obj);
			}

			@Override
			public void onModify(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("修改：{}-> {}", currentPath, obj);
			}

			@Override
			public void onDelete(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("删除：{}-> {}", currentPath, obj);
			}

			@Override
			public void onOverflow(WatchEvent<?> event, Path currentPath) {
				Object obj = event.context();
				Console.log("Overflow：{}-> {}", currentPath, obj);
			}
		};
		
		WatchMonitor monitor = WatchMonitor.createAll("d:/aaa/aaa.txt", new DelayWatcher(watcher, 500));
		
		monitor.setMaxDepth(0);
		monitor.start();
	}
	
	
}
