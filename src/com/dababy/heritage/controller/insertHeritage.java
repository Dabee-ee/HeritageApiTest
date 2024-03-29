package com.dababy.heritage.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.dababy.heritage.model.service.HeritageService;
import com.dababy.heritage.model.vo.Heritage;

/**
 * Servlet implementation class insertHeritage
 */
@WebServlet("/insert.do")
public class insertHeritage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public insertHeritage() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
	// tag값의 정보를 가져오는 메소드
	public String getTagValue(String tag, Element eElement) {
	    NodeList nlList = eElement.getElementsByTagName(tag).item(0).getChildNodes();
	    Node nValue = (Node) nlList.item(0);
	    if(nValue == null) 
	        return null;
	    return nValue.getNodeValue();
	   }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageIndex = 1;	// 페이지 초기값 

		// heritage 객체들을 저장할 list
		ArrayList<Heritage> list = new ArrayList<>();	
		
		
		 
		try{
			
			while(true){
				// parsing할 url 지정(API 키 포함해서)
				String url = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do?pageIndex="+pageIndex;
				
				DocumentBuilderFactory dbFactoty = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactoty.newDocumentBuilder();
				Document doc = dBuilder.parse(url);
				
				// root tag 
				doc.getDocumentElement().normalize();
				System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
				
				// 파싱할 tag
				NodeList nList = doc.getElementsByTagName("item");
				System.out.println("파싱할 리스트 수 : "+ nList.getLength());
			
				
				
				for(int temp = 0; temp < nList.getLength(); temp++){
					Node nNode = nList.item(temp);
					if(nNode.getNodeType() == Node.ELEMENT_NODE){
						
						Element eElement = (Element) nNode;
						
						// heritage vo를 저장할 객체 
						 Heritage heri = new Heritage();

						// api로 받은 정보 저장
							heri.setName(getTagValue("ccbaMnm1", eElement)); // 문화재명
							heri.setEvents(getTagValue("ccbaKdcd", eElement)); // 종목코드
							heri.setSerial(getTagValue("ccbaAsno", eElement)); // 지정번호
							heri.setZipcode(getTagValue("ccbaCtcd", eElement)); // 시도코드
							heri.setLng(getTagValue("longitude", eElement)); // 위도
							heri.setLat(getTagValue("latitude", eElement)); // 경도
							
							list.add(heri);
							
							// 서비스 시작!
							HeritageService service = new HeritageService();
							
							
							int result = service.insertHeritage(heri);

					}	// for end
					
				}	// if end
				pageIndex += 1;
				
				if(pageIndex > 12){ break; }
				
				}

			}	// while end
			
		
		catch (Exception e){	
			e.printStackTrace();
		
		}	// try~catch end
		
		response.sendRedirect("index.jsp");
		
	}	// main end
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
