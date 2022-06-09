package score;

import java.util.List;

import bean.Page;

public interface ScoreInterface {
	public String insert(ScoreVo vo);
	public String update(ScoreVo vo);
	public String delete(int sno);
	public ScoreVo SelectOne(int sno);
	public List<ScoreVo> select(Page p);
	public Page getPage();
}
