package com.kuang.dao;

import com.kuang.poro.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
  //插入数据
  public int addBlog(Blog blog);
  //查询博客
  public List<Blog>queryBlogIf(Map map);
  public List<Blog>queryBlogChoose(Map map);
//更新博客
  public int updateBlog(Map map);
  // 查询第1-2号记录的博客
  List<Blog>queryBlogForeach(Map map);
//用数组实现传参
  List<Blog>queryBlogForeach1(int []a);
//用集合实现传参
  List<Blog>queryBlogForeach2(List<Integer>b);

}

