package com.github.jobjava00.test;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author jobjava00
 */
@RunWith(SpringRunner.class)
public class OutputCaptureTests {

	@Rule public OutputCapture capture = new OutputCapture();  // System.out, System.err 출력 확인 - 실제 서비스 코드에서는 쓸일 없을듯... logger를 찍을듯

	@Test
	public void test(){
		System.out.println("Hello World!");
		assertThat(capture.toString()).contains("World!");
	}
}
