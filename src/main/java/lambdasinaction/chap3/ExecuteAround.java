package lambdasinaction.chap3;

import java.io.*;
public class ExecuteAround {

	public static void main(String ...args) throws IOException{

        // method we want to refactor to make more flexible
//        String result = processFileLimited();
//        System.out.println(result);

        System.out.println("---");

		String oneLine = processFile((BufferedReader b) -> b.readLine());
		System.out.println(oneLine);

		// 打印两行
		String twoLines = processFile(
				(BufferedReader b) -> b.readLine() + b.readLine()
		);
		System.out.println(twoLines);

	}

//    public static String processFileLimited() throws IOException {
//        try (BufferedReader br =
//                     new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))) {
//            return br.readLine();
//        }
//    }


	public static String processFile(BufferedReaderProcessor p) throws IOException {
		try(
				BufferedReader br = new BufferedReader(new FileReader("lambdasinaction/chap3/data.txt"))
		){
			return p.process(br);
		}

	}
	
	/**
	 * 接口(函数式写法)
	 */
	public interface BufferedReaderProcessor{
		// 1-匹配 BufferedReader -> String ; 2-能抛出IO异常
		public String process(BufferedReader b) throws IOException;

	}
}
