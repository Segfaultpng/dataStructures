import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Stephen on 11/28/2016.
 */
public class YourMazeWithPath
{
    private InputGraphicMaze maze;
    private int R, C;
    private int[][] V;
    //YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!

    public YourMazeWithPath()
    {
        // an R rows x C columns maze
        maze = new InputGraphicMaze();
        R=maze.Rows(); C=maze.Cols();

        V=new int[R+1][C+1];
        for (int i=1; i<=R; i++) {
            for (int j=1; j<=C; j++){
                V[i][j]=0;
            }
        }

        //YOU'LL NEED TO ADD MORE CODE HERE!!!!!!!
        // Path holds the cells of the path
        LinkedList<Point> Path = new LinkedList<Point>();
        // Create the path
        CreatePath(maze, 1, 1, R, C, Path);
        // show the path in the maze
        maze.showPath(Path);
    }

    // Creates the path through maze, starting at cell (srow, scol)
    // and ending at cell (erow and ecol),  in L
    public boolean CreatePath(InputGraphicMaze maze, int srow, int scol, int erow, int ecol, LinkedList<Point> L)
    {
        //YOUR CODE FOR THE PATH GENERATION GOES HERE!!!!!!!
        int r=srow, c=scol, R=maze.Rows(), C=maze.Cols(); int size=R*C+1;
        Point[] P=new Point[size];
        boolean done=false;
        if (V[srow][scol]!=1){

            V[srow][scol]=1;
            int scell=(srow-1)*C+scol;
            P[scell]=new Point(0,0); Point u=new Point(r, c);

            if ((r>1)&&(V[r-1][c]!=1)&&(maze.can_go(r, c,'U')))
            {
                V[r-1][c]=1;
                P[(r-2)*C+c]=u;
                //Q.add(new Point(r-1, c));
                CreatePath(maze,r-1,c,R,C,L);
            }
            if ((c<C)&&(V[r][c+1]!=1)&&(maze.can_go(r, c,'R')))
            {
                V[r][c+1]=1;
                P[(r-1)*C+c+1]=u;
                //Q.add(new Point(r, c+1));
                CreatePath(maze,r,c+1,R,C,L);
            }
            if ((r<R)&&(V[r+1][c]!=1)&&(maze.can_go(r, c, 'D')))
            {
                V[r+1][c]=1;
                P[r*C+c]=u;
                //Q.add(new Point(r+1, c));
                CreatePath(maze,r+1,c,R,C,L);
            }
            if ((c>1)&&(V[r][c-1]!=1)&&(maze.can_go(r, c, 'L')))
            {
                V[r][c-1]=1;
                P[(r-1)*C+c-1]=u;
                //Q.add(new Point(r, c-1));
                CreatePath(maze,r,c,R,C,L);
            }
            done = true;
        }


        return done;
    }

    public void dfs(int r, int c){

    }

    public static void main(String[] args)
    {new YourMazeWithPath();}
}