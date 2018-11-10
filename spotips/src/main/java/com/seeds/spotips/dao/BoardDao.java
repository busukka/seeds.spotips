package com.seeds.spotips.dao;

import java.util.List;
import java.util.Map;

import com.seeds.spotips.bean.Board;
import com.seeds.spotips.bean.BoardUpload;
import com.seeds.spotips.bean.Reply;

public interface BoardDao {

	public List<Board> getBoardList();

	public boolean fileUpload(Map<String, String> fMap);

	public boolean postUpload(Board board);

	public List<BoardUpload> getBoardUploadList();

	public Board postInfo(String b_no);

	public List<BoardUpload> postFileInfo(String b_no);

	public boolean replyInsert(Reply r);

	public List<Reply> getReplyList(String r_bno);

	public Reply replyNoCheck(String b_no);

}
