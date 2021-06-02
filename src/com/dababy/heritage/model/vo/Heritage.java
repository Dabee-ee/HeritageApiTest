package com.dababy.heritage.model.vo;

import java.io.Serializable;

public class Heritage implements Serializable{
		
		private static final long serialVersionUID = 1003L;
		
		// 서버 데이터 베이스 테이블과 매칭되는 vo입니다.
		private int heritage_id; // 문화재 식별자
		private String name; // 문화재명
		private String events; // 종목코드
		private String serial; // 지정번호
		private String zipcode; // 시도코드
		private String lng; // 경도
		private String lat; // 위도
		
		
		// 여기서부터는 공공데이터 api에서 받아올 데이터 입니다.
		// 서버에는 저장하지 않지만 데이터를 받아와야 하는 경우 이렇게 vo를 만들어서 사용하면 됩니다.
		private String ccmaName; // 문화재종목
		private String gcodeName; // 문화재분류
		private String ccbaAsdt; // 지정(등록일)
		private String ccbaLcad; // 소재지 상세
		private String ccceName; // 시대
		private String ccbaPoss; // 소유자
		private String ccbaAdmin; // 관리자
		private String imageUrl; // 메인노출이미지URL
		private String content; // 내용
		
		public Heritage(){}
		
		

		public Heritage(int heritage_id, String name, String events, String serial, String zipcode, String lng,
				String lat) {
			super();
			this.heritage_id = heritage_id;
			this.name = name;
			this.events = events;
			this.serial = serial;
			this.zipcode = zipcode;
			this.lng = lng;
			this.lat = lat;
		}



		public Heritage(int heritage_id, String name, String events, String serial, String zipcode, String lng,
				String lat, String ccmaName, String gcodeName, String ccbaAsdt, String ccbaLcad, String ccceName,
				String ccbaPoss, String ccbaAdmin, String imageUrl, String content) {
			super();
			this.heritage_id = heritage_id;
			this.name = name;
			this.events = events;
			this.serial = serial;
			this.zipcode = zipcode;
			this.lng = lng;
			this.lat = lat;
			this.ccmaName = ccmaName;
			this.gcodeName = gcodeName;
			this.ccbaAsdt = ccbaAsdt;
			this.ccbaLcad = ccbaLcad;
			this.ccceName = ccceName;
			this.ccbaPoss = ccbaPoss;
			this.ccbaAdmin = ccbaAdmin;
			this.imageUrl = imageUrl;
			this.content = content;
		}
		


		@Override
		public String toString() {
			return "Heritage [heritage_id=" + heritage_id + ", name=" + name + ", events=" + events + ", serial="
					+ serial + ", zipcode=" + zipcode + ", lng=" + lng + ", lat=" + lat + ", ccmaName=" + ccmaName
					+ ", gcodeName=" + gcodeName + ", ccbaAsdt=" + ccbaAsdt + ", ccbaLcad=" + ccbaLcad + ", ccceName="
					+ ccceName + ", ccbaPoss=" + ccbaPoss + ", ccbaAdmin=" + ccbaAdmin + ", imageUrl=" + imageUrl
					+ ", content=" + content + "]";
		}

		public int getHeritage_id() {
			return heritage_id;
		}

		public void setHeritage_id(int heritage_id) {
			this.heritage_id = heritage_id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getEvents() {
			return events;
		}

		public void setEvents(String events) {
			this.events = events;
		}

		public String getSerial() {
			return serial;
		}

		public void setSerial(String serial) {
			this.serial = serial;
		}

		public String getZipcode() {
			return zipcode;
		}

		public void setZipcode(String zipcode) {
			this.zipcode = zipcode;
		}

		public String getLng() {
			return lng;
		}

		public void setLng(String lng) {
			this.lng = lng;
		}

		public String getLat() {
			return lat;
		}

		public void setLat(String lat) {
			this.lat = lat;
		}

		public String getCcmaName() {
			return ccmaName;
		}

		public void setCcmaName(String ccmaName) {
			this.ccmaName = ccmaName;
		}

		public String getGcodeName() {
			return gcodeName;
		}

		public void setGcodeName(String gcodeName) {
			this.gcodeName = gcodeName;
		}

		public String getCcbaAsdt() {
			return ccbaAsdt;
		}

		public void setCcbaAsdt(String ccbaAsdt) {
			this.ccbaAsdt = ccbaAsdt;
		}

		public String getCcbaLcad() {
			return ccbaLcad;
		}

		public void setCcbaLcad(String ccbaLcad) {
			this.ccbaLcad = ccbaLcad;
		}

		public String getCcceName() {
			return ccceName;
		}

		public void setCcceName(String ccceName) {
			this.ccceName = ccceName;
		}

		public String getCcbaPoss() {
			return ccbaPoss;
		}

		public void setCcbaPoss(String ccbaPoss) {
			this.ccbaPoss = ccbaPoss;
		}

		public String getCcbaAdmin() {
			return ccbaAdmin;
		}

		public void setCcbaAdmin(String ccbaAdmin) {
			this.ccbaAdmin = ccbaAdmin;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		};
		
		
		
}
