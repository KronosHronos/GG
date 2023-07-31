package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;
import com.mygdx.game.g1.game.Program;
import com.mygdx.game.g1.units.Archer;
import com.mygdx.game.g1.units.BaseHero;
import com.mygdx.game.g1.units.Cultist;
import com.mygdx.game.g1.units.Demon;
import com.mygdx.game.g1.units.Farmer;
import com.mygdx.game.g1.units.Hound;
import com.mygdx.game.g1.units.Imp;
import com.mygdx.game.g1.units.LivingEmber;
import com.mygdx.game.g1.units.Mage;
import com.mygdx.game.g1.units.Monk;

import com.mygdx.game.g1.units.Rouge;
import com.mygdx.game.g1.units.Shadow;
import com.mygdx.game.g1.units.Sniper;
import com.mygdx.game.g1.units.Spearman;
import com.mygdx.game.g1.units.Succubus;

import java.util.Random;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture fons,livingEmber, CrossBowMan,Demon,Imp,Mage,Monk,Peasant,Rouge,Shadow,Sniper,SpearMan,Succubus,Hound;
	Program game;
	Music music;
	private boolean clk = true;

	@Override
	public void create () {
		game = new Program();
		batch = new SpriteBatch();
		fons = new Texture("fons/" + Fons.values()[new Random().nextInt(Fons.values().length)]+".png");
		music = Gdx.audio.newMusic(Gdx.files.internal("music/paul-romero-rob-king-combat-theme-0"+(new Random().nextInt(4)+1) +".mp3"));
		music.setLooping(true);
		music .setVolume(1);
		music.play();
		CrossBowMan= new Texture("char/CrossBowMan.png ");
		Demon= new Texture("char/Demon.png");
		livingEmber = new Texture("char/livingEmber.png");
		Imp = new Texture("char/Imp.png");
		Mage = new Texture("char/Mage.png");;
		Monk = new Texture("char/Monk.png");
		Peasant = new Texture("char/Peasant.png");
		Rouge = new Texture("char/Rouge.png");
		Shadow = new Texture("char/Shadow.png");
		Sniper = new Texture("char/Sniper.png");
		SpearMan = new Texture("char/SpearMan.png");
		Succubus = new Texture("char/Succubus.png");
		Hound = new Texture("char/Hound.png");
	}

	@Override
	public void render () {

		if (Gdx.input.isTouched() & clk){
			clk=false;
			if (game.step()) music.stop();{

			}
		}
		if (!Gdx.input.isTouched() & !clk) clk = true;

		ScreenUtils.clear(1, 0, 0, 1);
		batch.begin();
		batch.draw(fons, 0, 0, Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		int dx=Gdx.graphics.getWidth()/12;
		int dy=Gdx.graphics.getHeight()/15;
		for(BaseHero hero: game.unitedTeam){

			if (hero.getHp()<=0) continue;

			int m=1;
			if (game.team2.contains(hero)) m = -1;
			if (hero instanceof Archer) batch.draw(CrossBowMan,hero.getPlace().x*dx, hero.getPlace().y*dy, CrossBowMan.getWidth()*m,CrossBowMan.getHeight());
			if (hero instanceof Spearman) batch.draw(SpearMan,hero.getPlace().x*dx, hero.getPlace().y*dy, SpearMan.getWidth()*m,SpearMan.getHeight());
			if (hero instanceof Farmer) batch.draw(Peasant,hero.getPlace().x*dx, hero.getPlace().y*dy, Peasant.getWidth()*m,Peasant.getHeight());
			if (hero instanceof Monk) batch.draw(Monk,hero.getPlace().x*dx, hero.getPlace().y*dy, Monk.getWidth()*m,Monk.getHeight());
			if (hero instanceof Mage) batch.draw(Mage,hero.getPlace().x*dx, hero.getPlace().y*dy, Mage.getWidth()*m,Mage.getHeight());
			if (hero instanceof Sniper) batch.draw(Sniper,hero.getPlace().x*dx, hero.getPlace().y*dy, Sniper.getWidth()*m,Sniper.getHeight());
			if (hero instanceof Cultist) batch.draw(Monk,hero.getPlace().x*dx, hero.getPlace().y*dy, Monk.getWidth()*m,Monk.getHeight());
			if (hero instanceof Succubus) batch.draw(Succubus,hero.getPlace().x*dx, hero.getPlace().y*dy, Succubus.getWidth(),Succubus.getHeight());
			if (hero instanceof Shadow) batch.draw(Shadow,hero.getPlace().x*dx, hero.getPlace().y*dy, Shadow.getWidth()*m,Shadow.getHeight());
			if (hero instanceof Hound) batch.draw(Hound,hero.getPlace().x*dx, hero.getPlace().y*dy, Hound.getWidth()*m,Hound.getHeight());
			if (hero instanceof LivingEmber) batch.draw(livingEmber,hero.getPlace().x*dx, hero.getPlace().y*dy, livingEmber.getWidth()*m,livingEmber.getHeight());
			if (hero instanceof Rouge) batch.draw(Rouge,hero.getPlace().x*dx, hero.getPlace().y*dy, Rouge.getWidth()*m,Rouge.getHeight());
			if (hero instanceof Demon) batch.draw(Demon,hero.getPlace().x*dx, hero.getPlace().y*dy, Demon.getWidth()*m,Demon.getHeight());
			if (hero instanceof Imp) batch.draw(Imp,hero.getPlace().x*dx, hero.getPlace().y*dy, Imp.getWidth()*m,Imp.getHeight());
		}

		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		fons.dispose();
		music.dispose();
		livingEmber.dispose();
		CrossBowMan.dispose();
		Demon.dispose();
		Imp.dispose();
		Mage.dispose();
		Monk.dispose();
		Peasant.dispose();
		Rouge.dispose();
		Shadow.dispose();
		Sniper.dispose();
		SpearMan.dispose();
		Succubus.dispose();
		Hound.dispose();
	}
}
