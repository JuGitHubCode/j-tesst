package mybatis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import score.ScoreVo;

public class DynamicTest {

	public void ifTest() {
		SqlSession session=MybaFactory.getFactory().openSession();
		int s=90;
		List<ScoreVo> list=session.selectList("dynamic.select_90", s);
		System.out.println("size:"+list.size());
		
	}
	
	
	public void choose() {
		//파라메터가 "총점"이면 성적의 전체합계를
		//"평균"이면 평균값을,"최대값" 성적의 최대값을 반환
		SqlSession session=MybaFactory.getFactory().openSession();
		
		String param="평균값";
		
		double v=session.selectOne("dynamic.choose",param);
		System.out.println(param+":"+v);
		
	}
	
	
	public void forEach() {
		//학번 1개 이상 전달 해당 성적을 반환
		List<Integer> sno=new ArrayList<Integer>();
		sno.add(501);
		sno.add(500);
		sno.add(499);
		
		SqlSession session=MybaFactory.getFactory().openSession();
		List<ScoreVo> list=session.selectList("dynamic.foreach1",sno);
		
		for(ScoreVo v: list) {
			System.out.println(v.getSno() +"의 점수는"+v.getScore());
		}	
	}
	
	public void forEach2() {
		//key:value 각각 sno:score 값을 전달 받아 해당 sno 학생 성적 수정
		
		SqlSession session=MybaFactory.getFactory().openSession();
		Map<String,Integer> map=new HashMap<String, Integer>();
		map.put("sno", 501);
		map.put("score", 50);
		
		int cnt=session.update("dynamic.score_update",map);
		if(cnt>0) {
			session.commit();
			System.out.println("완료");
		}else {
			session.rollback();
			System.out.println("오류");
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		DynamicTest d=new DynamicTest();
		d.ifTest();
		d.choose();
		d.forEach();
		d.forEach2();
		
	}

}
