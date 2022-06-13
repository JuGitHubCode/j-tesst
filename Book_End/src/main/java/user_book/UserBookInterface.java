package user_book;

import java.util.List;

import bean.Page;

public interface UserBookInterface {
	List<UserBookVo> select(Page p);
	
}
