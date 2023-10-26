import com.kuang.dao.BlogMapper;
import com.kuang.poro.Blog;
import com.kuang.utils.IDutils;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

public class MyTest {
    @Test
    public void addInitBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);

        Blog blog = new Blog();
        blog.setId(IDutils.getId());
        blog.setTitle("Mybatis如此简单");
        blog.setAuthor("狂神说");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Java如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("Spring如此简单");
        mapper.addBlog(blog);

        blog.setId(IDutils.getId());
        blog.setTitle("微服务如此简单");
        mapper.addBlog(blog);

        session.close();
    }
    @Test
    public void queryBlogIf(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Map map=new HashMap();
       map.put("title","Java如此简单");
       map.put("author","狂神说");

List<Blog> blogs= mapper.queryBlogIf(map);
        for (Blog blog:blogs){
            System.out.println(blog);
        }
        session.close();
    }
    @Test
    public void queryBlogChoose(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Map map=new HashMap();
        map.put("title","Java如此简单");
         map.put("author","狂神说");
          map.put("views",9999);
        List<Blog> blogs= mapper.queryBlogChoose(map);
        for (Blog blog:blogs){
            System.out.println(blog);
        }
        session.close();
    }
    @Test
    public void updateBlog(){
        SqlSession session = MybatisUtils.getSqlSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Map map=new HashMap();
       map.put("title","Java如此简单2");
        //map.put("author","狂神说2");
        map.put("id","4b87da0b51484aa8a23a72ac7b4061f1");
         mapper.updateBlog(map);
        session.close();
    }
    @Test
    public void queryBlogForEach(){
    SqlSession sqlSession=MybatisUtils.getSqlSession();
    BlogMapper blogMapper =sqlSession.getMapper(BlogMapper.class);
    HashMap  map =new HashMap();
        ArrayList<Integer> ids=new ArrayList<Integer>();
        ids.add(1);
        ids.add(2);
        map.put("ids",ids);
   List<Blog>   blogs=blogMapper.queryBlogForeach(map);
   for(Blog blog:blogs)
   {
       System.out.println(blog);
   }
   sqlSession.close();
    }
@Test
    public void queryBlogForEach1(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper =sqlSession.getMapper(BlogMapper.class);
        int []array={1,2};
        List<Blog>   blogs=blogMapper.queryBlogForeach1(array);
        for(Blog blog:blogs)
        {
            System.out.println(blog);
        }
        sqlSession.close();}
    @Test
    public void queryBlogForEach2(){
        SqlSession sqlSession=MybatisUtils.getSqlSession();
        BlogMapper blogMapper =sqlSession.getMapper(BlogMapper.class);
        List<Integer> ids= new ArrayList<>();
        ids.add(1);
        ids.add(2);
        List<Blog>   blogs=blogMapper.queryBlogForeach2(ids);
        for(Blog blog:blogs)
        {
            System.out.println(blog);
        }
        sqlSession.close();}

}
