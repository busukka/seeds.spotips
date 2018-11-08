package com.seeds.spotips.dao;

import java.util.List;
import java.util.Map;

import com.seeds.spotips.bean.Board;
import com.seeds.spotips.bean.BoardUpload;

public interface BoardDao {

	public List<Board> getBoardList();

	public boolean fileUpload(Map<String, String> fMap);

	public boolean postUpload(Board board);

	public List<BoardUpload> getBoardUploadList();

}
