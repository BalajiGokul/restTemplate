package com.inautix.mdsQuotetoolWeb.App;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.SerializationFeature;
//import mkd.bxp.TestCaseCheck.QuoteRequest.RepeatedFields;

/**
 * Hello world!
 * 
 */
public class App {
	public static void main(String[] args) throws Exception {

		/*
		 * fix for Exception in thread "main"
		 * javax.net.ssl.SSLHandshakeException:
		 * sun.security.validator.ValidatorException: PKIX path building failed:
		 * sun.security.provider.certpath.SunCertPathBuilderException: unable to
		 * find valid certification path to requested target
		 */

		TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
			public java.security.cert.X509Certificate[] getAcceptedIssuers() {
				return null;
			}

			public void checkClientTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {

			}

			public void checkServerTrusted(X509Certificate[] chain,
					String authType) throws CertificateException {

			}
		} };

		SSLContext sc = SSLContext.getInstance("SSL");
		sc.init(null, trustAllCerts, new java.security.SecureRandom());
		HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());

		@SuppressWarnings("unused")
		HostnameVerifier allHostsValid = new HostnameVerifier() {

			public boolean verify(String hostname, SSLSession session) {
				return true;
			}
		};

		System.out.println(".............program started...........");

//		final String uri = "http://172.24.18.166:9090/person/create";
//		final String uri = "http://172.19.21.174:8080/mds-restquote/getmarketquotes";
		final String uri = "http://172.24.18.102:8080/mds-quotetool-web/quotelookup/restQuote";
		
		// final String uri =
		// "http://r00c1tn0c:10067/mds-restquote/getmarketquotes";
		QuoteRequest singlequoteRequest = new QuoteRequest();
		/*singlequoteRequest.setSiteId("02#NGWB");
		singlequoteRequest.setCustomerId("TSOCSUB");
		singlequoteRequest.setNetworkId('Y');
		singlequoteRequest.setQtChrgInd('Y');
		singlequoteRequest.setQtRqstType("SING");
		singlequoteRequest.setCorrespondentNum("511");
		singlequoteRequest.setSendDlOnFailInd('Y');
		singlequoteRequest.setItemCnt(1);

		ArrayList<RepeatedFields> rep = new ArrayList<QuoteRequest.RepeatedFields>();

		RepeatedFields repeated = new RepeatedFields();

		repeated.setSymId("GOOG");
		repeated.setBlockCount(1);
		rep.add(repeated);
		singlequoteRequest.setRepeated(rep);
*/
		/*
		
		singlequoteRequest.setId(11);
		singlequoteRequest.setName("BalajiRagu");
		singlequoteRequest.setAge(22);
		singlequoteRequest.setGender("Male");
		*/
		
		singlequoteRequest.setReportType("summary");
		singlequoteRequest.setFromdt("2016-04-20");
		singlequoteRequest.setTodate("2018-05-20");
		singlequoteRequest.setProduct("netx360");
		
		com.fasterxml.jackson.databind.ObjectMapper mapper = new com.fasterxml.jackson.databind.ObjectMapper();
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

		HttpHeaders requestHeaders = new HttpHeaders();

		requestHeaders.set("Content-Type", "application/json");

		/* requestHeaders.set("Accept", "application/json"); */

		requestHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));

		HttpEntity<String> requestEntity = new HttpEntity<String>(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(singlequoteRequest).toString(), requestHeaders);

		System.out.println("input json=====>" + requestEntity.getBody());

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
		
		String arr [] = response.getBody().split(",");
		
		for(String s : arr)
		{
			if(s.equals("}"))
				System.out.println("");
			System.out.println(s);
			
			
		}
		
		
		System.out.println("\n\noutput json======>" + response.getBody());
	}
}
