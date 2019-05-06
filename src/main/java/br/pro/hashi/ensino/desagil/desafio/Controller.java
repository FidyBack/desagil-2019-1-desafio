package br.pro.hashi.ensino.desagil.desafio;

import br.pro.hashi.ensino.desagil.desafio.model.CpuPlayer;
import br.pro.hashi.ensino.desagil.desafio.model.HumanPlayer;
import br.pro.hashi.ensino.desagil.desafio.model.Model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener, ActionListener {
    private final Model model;
    private final View view;


    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }


    @Override
    public void keyTyped(KeyEvent event) {
    }


    @Override
    public void keyPressed(KeyEvent event) {
        HumanPlayer humanPlayer = model.getHumanPlayer();

        if (model.getWinner() == null) {
            switch (event.getKeyCode()) {
                case KeyEvent.VK_UP:
                    humanPlayer.moveUp();
                    break;
                case KeyEvent.VK_RIGHT:
                    humanPlayer.moveRight();
                    break;
                case KeyEvent.VK_DOWN:
                    humanPlayer.moveDown();
                    break;
                case KeyEvent.VK_LEFT:
                    humanPlayer.moveLeft();
                    break;
            }
        }
        view.repaint();
    }


    @Override
    public void keyReleased(KeyEvent event) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (model.getWinner() == null) {
            CpuPlayer cpuPlayer = model.getCpuPlayer();

            cpuPlayer.move();

            view.repaint();
        }
    }
}
