package mybatis;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import score.ScoreVo;

public class MybaTest {

	public static void main(String[] args) {
		//1)sqlsession 생성
		SqlSession session=MybaFactory.getFactory().openSession();
		
		//2)score table의 데이터 건수
		int cnt=session.selectOne("test.tot_list","국어");
		System.out.println("cnt :" + cnt);
		
		
		//3)전산과목의 합
		List<Integer> list=(ArrayList)session.selectList("test.score_hap","전산");
		int hap=0;
		for(int i : list) {
			System.out.println(i);
			hap+=+i;
		}
		System.out.println("합 : "+ hap);
		
		
		//전산 과목 응시자의 학번과 점수
		List<ScoreVo> vo=(ArrayList)session.selectList("test.sno_score", "전산");
		for(ScoreVo v :vo) {
			System.out.println(v.getSno()+"/"+v.getScore());
		}
		
		
		//전산 시험 응시자 id, mname, phone, email, score
		List<ScoreVo> so=(ArrayList)session.selectList("test.e_test", "전산");
		for(ScoreVo s :so) {
			System.out.println(s.getSno()+"/"+s.getScore()+"/"+s.getmName()+"/"+s.getPhone()+"/"+s.getEmail());
		}
		
		
		//임의의 성적을 추가
		/*
		ScoreVo v2=new ScoreVo();
		v2.setNal("2022-05-24");
		v2.setId("a002");
		v2.setSubject("국어");
		v2.setScore(100);
		
		cnt=session.insert("test.score_input",v2);
		if(cnt>0) {
			System.out.println("자장완료") ;
			session.commit();
		}else {
			System.out.println("자장 오류");
			session.rollback();
		}
		*/
		
		//sno와 과목 기준으로 점수 수정
		ScoreVo v3=new ScoreVo();
		v3.setSno(504);
		v3.setScore(60);
		v3.setSubject("국어");
		
		cnt=session.insert("score_update", v3);
		if(cnt>0) {
			System.out.println("완료");
			session.commit();
		}else {
			System.out.println("오류");
			session.rollback();
		}
		
		
		//sno 504의 국어 삭제
		ScoreVo v4=new ScoreVo();
		v4.setSno(504);
		v4.setSubject("국어");
		
		cnt=session.delete("score_delete", v4);
		if(cnt>0) {
			System.out.println("완료");
			session.commit();
		}else {
			System.out.println("오류");
			session.rollback();
		}
		
	}

}
