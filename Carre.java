import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class Carre extends Applet implements Runnable
{
  private int rouge=0, vert=0, bleu=0;
  private boolean mustStop;
  Frame f;
  public void start()
  {
    this.mustStop = false;
    (new Thread(this)).start();
  }

  public void stop()
  {
    this.mustStop = true;
  }

  public void run()
  {
    int cpt = 0;
    while (true && cpt<20)
    {
      this.paint(this.getGraphics());
      try {
        Thread.sleep(1000);
      } catch (Exception e) { 
        f = new Frame("Erreur");
        f.add(new Label("Une erreur s'est produite durant l'exécution du traitement !"+ e));
        f.setSize(300, 400);
        f.show();
      }
      if (this.mustStop == true)
        return;
      cpt++;
    }
  }

  public int chiffrealeatoire(int valeur)
  {
    return (int)(Math.random()*valeur);
  }


  public void paint(Graphics gc)
  {
    int x=0, y=0,longueur=0;
    // On récupère les dimensions du canevas
    Dimension taille = getSize();

    // On créé une valeur aléatoire RGB
    rouge = this.chiffrealeatoire(255);
    vert = this.chiffrealeatoire(255);
    bleu = this.chiffrealeatoire(255);

    // On renseigne les valeurs du carré : x, y et la longueur d'un côté
    longueur = this.chiffrealeatoire(150);
    x = this.chiffrealeatoire(taille.width-2*longueur)+longueur;
    y = this.chiffrealeatoire(taille.height-2*longueur)+longueur;

    // do {
    //  x = this.chiffrealeatoire(taille.width);
    // } while ( (x-longueur)<0 || (x+longueur) > taille.width );

    // do {
    //  y = this.chiffrealeatoire(taille.height);
    // } while ( (y-longueur)<0 || (y+longueur) > taille.height );

    gc.setColor(new Color(rouge,vert,bleu));
    gc.fillRect(x,y,longueur,longueur);
  }
}