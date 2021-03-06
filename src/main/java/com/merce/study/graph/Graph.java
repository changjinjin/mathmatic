package com.merce.study.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName Graph
 * @Deacription 图
 * @Author Administrator
 * @Date 2020/12/29 17:26
 * @Version 1.0
 **/
public class Graph {

    private ArrayList<String> vertexList;
    private int[][] edges;
    private int num0fEdges;
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 8;
        String Vertexs[] = {"A", "B", "C", "D", "E"};
//        String Vertexs[] = {"1", "2", "3", "4", "5", "6", "7", "8"};
        Graph graph = new Graph(n);
        for(String vertex : Vertexs){
            graph.insertVertex(vertex);
        }

        //添加边
        //A-B A-C B-C B-D B-E

		graph.insertEdge(0, 1, 1); // A-B
		graph.insertEdge(0, 2, 1); //
		graph.insertEdge(1, 2, 1); //
		graph.insertEdge(1, 3, 1); //
		graph.insertEdge(1, 4, 1); //


        //更新边的关系
//        graph.insertEdge(0, 1, 1);
//        graph.insertEdge(0, 2, 1);
//        graph.insertEdge(1, 3, 1);
//        graph.insertEdge(1, 4, 1);
//        graph.insertEdge(3, 7, 1);
//        graph.insertEdge(4, 7, 1);
//        graph.insertEdge(2, 5, 1);
//        graph.insertEdge(2, 6, 1);
//        graph.insertEdge(5, 6, 1);


        graph.showGraph();

        System.out.println("深度优先遍历");
        graph.dfs(); // A->B->C->D->E [1->2->4->8->5->3->6->7]
		System.out.println();
        System.out.println("广度优先遍历!");
        graph.bfs(); // A->B->C->D-E [1->2->3->4->5->6->7->8]
    }

    public Graph(int n) {
        this.vertexList = new ArrayList<>(n);
        this.edges = new int[n][n];
        this.num0fEdges = 0;
    }

    //得到第一个邻接结点的下标 w
    public int getFirstNeighbor(int index){
        for(int j = 0; j < vertexList.size(); j++){
            if(edges[index][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标来获取下一个邻接结点
    public int getNextNeighbor(int v1, int v2){
        for(int j = v2 + 1; j < vertexList.size(); j++){
            if(edges[v1][j] > 0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    //i 第一次就是 0
    private void dfs(boolean[] isVisited, int i){
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while(w != -1){
            if(!isVisited[w]){
                dfs(isVisited, w);
            }
            //如果w结点已经被访问过
            w = getNextNeighbor(i, w);
        }
    }

    //对dfs 进行一个重载, 遍历我们所有的结点，并进行 dfs
    public void dfs() {
        isVisited = new boolean[vertexList.size()];
        //遍历所有的结点，进行dfs[回溯]
        for(int i = 0; i < getNumOfVertex(); i++){
            if(!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    //返回结点i(下标)对应的数据 0->"A" 1->"B" 2->"C"
    public String getValueByIndex(int i){
        return vertexList.get(i);
    }

    //图中常用的方法
    //返回结点的个数
    public int getNumOfVertex() {
        return vertexList.size();
    }

    //对一个结点进行广度优先遍历的方法
    private void bfs(boolean[] isVisited, int i) {
        int u;// 表示队列的头结点对应下标
        int w;// 邻接结点w
        //队列，记录结点访问的顺序
        LinkedList queue = new LinkedList();
        System.out.println(getValueByIndex(i) + "->");
        isVisited[i] = true;
        queue.addLast(i);

        while(!queue.isEmpty()){
            u = (Integer) queue.removeFirst();
            w = getFirstNeighbor(u);
            while(w != -1){
                if(!isVisited[w]){
                    System.out.print(getValueByIndex(w) + "=>");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                //以u为前驱点，找w后面的下一个邻结点
                w = getNextNeighbor(u, w);
            }
        }
    }

    //遍历所有的结点，都进行广度优先搜索
    public void bfs() {
        isVisited = new boolean[vertexList.size()];
        for(int i = 0; i < getNumOfVertex(); i++){
            if(!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    //显示图对应的矩阵
    public void showGraph() {
        for(int[] link : edges){
            System.out.println(Arrays.toString(link));
        }
    }

    //得到边的数目
    public int getNumOfEdges() {
        return num0fEdges;
    }

    //返回v1和v2的权值
    public int getWeight(int v1, int v2){
        return edges[v1][v2];
    }

    //插入结点
    public void insertVertex(String vertex){
        vertexList.add(vertex);
    }

    /**
     *
     * @param v1 表示点的下标  即第几个顶点  "A"-"B" "A"->0 "B"->1
     * @param v2 第二个顶点对应的下标
     * @param weight 表示
     */
    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        num0fEdges++;
    }
}
