package parts;

import java.util.List;

import bean.Page;

public interface PartsInterface {
	public String insert(PartsVo vo);
	public List<PartsVo> select(Page page);
	public PartsVo selectOne(String code);
	public String update(PartsVo vo);
	public String delete(String code);
}
