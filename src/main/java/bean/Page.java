package bean;

import javax.swing.text.html.StyleSheet.ListPainter;

public class Page {
	int startNo;//목록의 시작위치
	int endNo;//목록의 끝위치
	int listSize=10;//목록의 행수
	int totSize;//검색된 전체 건수
	int blockSize=3;//표시된 페이지의 개수
	int startPage;//페이지의 시작 위치
	int endPage;//페이지의 끝 위치
	int totPage;//전체 페이지
	int nowPage=1;//사용자가 보고 있는 페이지
	String findStr;//
	
	public Page() {
		compute();
	}

	public Page(int totSize, int nowPage) {
		this.totSize=totSize;
		this.nowPage=nowPage;
		compute();
	}

	public void compute(){
		totPage=(int)Math.ceil(totSize/(double)listSize);
		endNo=listSize*nowPage+1;
		startNo=endNo-listSize;
		if(endNo>totSize) {
			endNo=totSize;
		}
		
		
		endPage=(int)Math.ceil(nowPage/(double)blockSize)*blockSize;
		startPage=endPage-blockSize+1;
		if(endPage>totPage)endPage=totPage;
	}
	
	public static void main(String[] args) {
		Page p=new Page();
		p.setTotSize(6);
		p.setNowPage(5);
		p.compute();
		System.out.println("totPage "+p.getTotPage());
		System.out.println("StartNo "+p.getStartNo());
		System.out.println("EndNo "+p.getEndNo());
		System.out.println("StartPage "+p.getStartPage());
		System.out.println("EndNo "+p.getEndPage());
	}
	
	public int getStartNo() {
		return startNo;
	}

	public void setStartNo(int startNo) {
		this.startNo = startNo;
	}

	public int getEndNo() {
		return endNo;
	}

	public void setEndNo(int endNo) {
		this.endNo = endNo;
	}

	public int getListSize() {
		return listSize;
	}

	public void setListSize(int listSize) {
		this.listSize = listSize;
	}

	public int getTotSize() {
		return totSize;
	}

	public void setTotSize(int totSize) {
		this.totSize = totSize;
	}

	public int getBlockSize() {
		return blockSize;
	}

	public void setBlockSize(int blockSize) {
		this.blockSize = blockSize;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotPage() {
		return totPage;
	}

	public void setTotPage(int totPage) {
		this.totPage = totPage;
	}

	public int getNowPage() {
		return nowPage;
	}

	public void setNowPage(int nowPage) {
		this.nowPage = nowPage;
	}

	public String getFindStr() {
		return findStr;
	}

	public void setFindStr(String findStr) {
		this.findStr = findStr;
	}
}

