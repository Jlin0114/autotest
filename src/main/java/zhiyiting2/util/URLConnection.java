package zhiyiting2.util;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.activation.MimetypesFileTypeMap;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;

import zhiyiting2.model.ResponseModel;
@Component
public class URLConnection { 
	
	public String cookie="";
	public String doPost(String url,String parameter) throws Exception {

        /* Translate parameter map to parameter date string */
        StringBuffer parameterBuffer = new StringBuffer();
        
        System.out.println("POST parameter : " + parameter);

        URL localURL = new URL(url);

        HttpURLConnection httpURLConnection = (HttpURLConnection)localURL.openConnection();
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("Cookie", cookie);
//        httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
        httpURLConnection.setRequestProperty("deviceId", "5555283CB8B84F02866D916B3FFD9909");
        httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
        httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36");
//        httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));
        OutputStream outputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader reader = null;
        StringBuffer resultBuffer = new StringBuffer();
        String tempLine = null;

        try {
            outputStream = httpURLConnection.getOutputStream();
            outputStreamWriter = new OutputStreamWriter(outputStream);
            
            outputStreamWriter.write(parameter.toString());
            outputStreamWriter.flush();

//            if (httpURLConnection.getResponseCode() >= 300) {
//                throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
//            }

            inputStream = httpURLConnection.getInputStream();
            inputStreamReader = new InputStreamReader(inputStream);
            reader = new BufferedReader(inputStreamReader);

            while ((tempLine = reader.readLine()) != null) {
                resultBuffer.append(tempLine);
            }

            
            String session_value = "";
            if(httpURLConnection.getHeaderField("Set-Cookie")!=null) {
            	session_value=httpURLConnection.getHeaderField("Set-Cookie");
            	String[] sessionId = session_value.split(";");  
                cookie=sessionId[0];
     
            }
            
            
            
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
            if (outputStream != null) {
                outputStream.close();
            }
            if (reader != null) {
                reader.close();
            }
            if (inputStreamReader != null) {
                inputStreamReader.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (httpURLConnection != null) {
            	httpURLConnection.disconnect();;
            }
        }
        
       
        System.out.println(resultBuffer.toString());
        return cookie;
        
    }
    
    
    
    public String doPost(String cookie,String url,String parameter) throws Exception{
   	 /* Translate parameter map to parameter date string */
       StringBuffer parameterBuffer = new StringBuffer();
       System.out.println("POST parameter : " + parameter);
       URL localURL = new URL(url);
       HttpURLConnection httpURLConnection = (HttpURLConnection)localURL.openConnection();
       httpURLConnection.setDoOutput(true);
       httpURLConnection.setRequestMethod("POST");
       httpURLConnection.setRequestProperty("Cookie", cookie);
//       httpURLConnection.setRequestProperty("Accept-Charset", "UTF-8");
//       httpURLConnection.setRequestProperty("deviceId", "5555283CB8B84F02866D916B3FFD9909");
       httpURLConnection.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
       httpURLConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36");
//       httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));
       OutputStream outputStream = null;
       OutputStreamWriter outputStreamWriter = null;
       InputStream inputStream = null;
       InputStreamReader inputStreamReader = null;
       BufferedReader reader = null;
       StringBuffer resultBuffer = new StringBuffer();
       String tempLine = null;
       String result="";
       try {
           outputStream = httpURLConnection.getOutputStream();
           outputStreamWriter = new OutputStreamWriter(outputStream);
           
           outputStreamWriter.write(parameter.toString());
           outputStreamWriter.flush();

//           if (httpURLConnection.getResponseCode() >= 300) {
//               throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
//           }

           inputStream = httpURLConnection.getInputStream();
           inputStreamReader = new InputStreamReader(inputStream);
           reader = new BufferedReader(inputStreamReader);
           result = reader.readLine();
//           while ((tempLine = reader.readLine()) != null) {
//               resultBuffer.append(tempLine);
//           }

       } finally {
           if (outputStreamWriter != null) {
               outputStreamWriter.close();
           }
           if (outputStream != null) {
               outputStream.close();
           }
           if (reader != null) {
               reader.close();
           }
           if (inputStreamReader != null) {
               inputStreamReader.close();
           }
           if (inputStream != null) {
               inputStream.close();
           }

       }
       
//	    ResponseModel responseModel= JSONObject.parseObject(result,ResponseModel.class);
//      
//       System.out.println(result);
       return result;
   }
    public ResponseModel getResponseModel(String result) {
    	 ResponseModel responseModel= JSONObject.parseObject(result,ResponseModel.class);
    	 return responseModel;
    }
    
    
    public 	String doPostForm(String cookie, String urlStr,Map textMap,  
            Map<String, String> fileMap) throws Exception{
    	 InputStream inputStream = null;
         InputStreamReader inputStreamReader = null;
         BufferedReader reader = null;
         DataInputStream in=null;
         HttpURLConnection conn = null;  
         ResponseModel responseModel = null;
         OutputStream out = null;
         String result="";
         String BOUNDARY = "---------------------------123821742118716"; //boundary就是request头和上传文件内容的分隔符  
         try {  
             URL url = new URL(urlStr);  
             conn = (HttpURLConnection) url.openConnection();  
             conn.setConnectTimeout(5000);  
             conn.setReadTimeout(30000);  
             conn.setDoOutput(true);  
             conn.setDoInput(true);  
             conn.setUseCaches(false);  
             conn.setRequestMethod("POST");  
//             conn.setRequestProperty("Connection", "Keep-Alive");  
             conn  
                     .setRequestProperty("User-Agent",  
                             "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.116 Safari/537.36");  
             conn.setRequestProperty("Content-Type",  
                     "multipart/form-data; boundary=" + BOUNDARY);  
             conn.setRequestProperty("Cookie", cookie);
             out  = new DataOutputStream(conn.getOutputStream());  
             // text  
             if (textMap != null) {  
                 StringBuffer strBuf = new StringBuffer();  
                 Iterator iter = textMap.entrySet().iterator();  
                 while (iter.hasNext()) {  
                     Map.Entry entry = (Map.Entry) iter.next();  
                     String inputName = (String) entry.getKey();  
                     String inputValue = String.valueOf(entry.getValue());  
                     if (inputValue == null) {  
                         continue;  
                     }  
                     strBuf.append("\r\n").append("--").append(BOUNDARY).append(  
                             "\r\n");  
                     strBuf.append("Content-Disposition: form-data; name=\""  
                             + inputName + "\"\r\n\r\n");  
                     strBuf.append(inputValue);  
                 }  
                 out.write(strBuf.toString().getBytes());  
             }  
   
             // file  
             if (fileMap != null) {  
                 Iterator iter = fileMap.entrySet().iterator();  
                 while (iter.hasNext()) {  
                     Map.Entry entry = (Map.Entry) iter.next();  
                     String inputName = (String) entry.getKey();  
                     String inputValue = (String) entry.getValue();  
                     if (inputValue == null) {  
                         continue;  
                     }  
                     File file = new File(inputValue);  
                     String filename = file.getName();  
                     String contentType = new MimetypesFileTypeMap()  
                             .getContentType(file);  
                     if (filename.endsWith(".png")) {  
                         contentType = "image/png";  
                     }  
                     if (contentType == null || contentType.equals("")) {  
                         contentType = "application/octet-stream";  
                     }  
   
                     StringBuffer strBuf = new StringBuffer();  
                     strBuf.append("\r\n").append("--").append(BOUNDARY).append(  
                             "\r\n");  
                     strBuf.append("Content-Disposition: form-data; name=\""  
                             + inputName + "\"; filename=\"" + filename  
                             + "\"\r\n");  
                     strBuf.append("Content-Type:" + contentType + "\r\n\r\n");  
   
                     out.write(strBuf.toString().getBytes());  
   
                     in= new DataInputStream(  
                             new FileInputStream(file));  
                     int bytes = 0;  
                     byte[] bufferOut = new byte[1024];  
                     while ((bytes = in.read(bufferOut)) != -1) {  
                         out.write(bufferOut, 0, bytes);  
                     }  
                       
                 }  
             }  
   
             byte[] endData = ("\r\n--" + BOUNDARY + "--\r\n").getBytes();  
             out.write(endData);  
             out.flush();  
             out.close();  
             
            
             // 读取返回数据  
             inputStream = conn.getInputStream();
             inputStreamReader = new InputStreamReader(inputStream);
            
             reader = new BufferedReader(inputStreamReader);
             result = reader.readLine();
             
//             responseModel= JSONObject.parseObject(result,ResponseModel.class);
             
             System.out.println(result);
             
             
         } catch (Exception e) {  
             System.out.println("发送POST请求出错。" + urlStr);  
             e.printStackTrace();  
         } finally {  
             if (conn != null) {  
                 conn.disconnect();  
                 conn = null;  
             }  
             if (reader != null) {
                 reader.close();
             }
             if (inputStreamReader != null) {
                 inputStreamReader.close();
             }
             if (inputStream != null) {
                 inputStream.close();
             } 
             if (in != null) {
            	 in.close();
             }
             if (out != null) {
            	 out.close();
             }
         }  
         return result; 
    }
    
    
}