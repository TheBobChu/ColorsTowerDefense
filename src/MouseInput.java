
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseInput extends MouseAdapter {
	
	private Handler handler;
	private boolean towerInHand = false;
	private int refundableMoney = 0;
	
	public MouseInput(Handler handler) {
		this.handler = handler;
	}
	
	public void mouseMoved(MouseEvent e) {
		if (!handler.paused) {
			int hoverMX = e.getX();
			int hoverMY = e.getY();
			// Hovering Over Towers In Shop To See The Stats Of The Hovered Tower
			if (!towerInHand && !handler.selectedATower) {
				// Red Tower
				if (mouseOver(hoverMX, hoverMY, 706, 105, 56, 56)) {
					handler.hoverUITower = 1;
				}
				// Orange Tower
				else if (mouseOver(hoverMX, hoverMY, 774, 105, 56, 56)) {
					handler.hoverUITower = 2;
				}
				// Yellow Tower
				else if (mouseOver(hoverMX, hoverMY, 706, 173, 56, 56)) {
					handler.hoverUITower = 3;
				}
				// Green Tower
				else if (mouseOver(hoverMX, hoverMY, 774, 173, 56, 56)) {
					handler.hoverUITower = 4;
				}
				// Blue Tower
				else if (mouseOver(hoverMX, hoverMY, 706, 241, 56, 56)) {
					handler.hoverUITower = 5;
				}
				// Purple Tower
				else if (mouseOver(hoverMX, hoverMY, 774, 241, 56, 56)) {
					handler.hoverUITower = 6;
				}
				// Gray Tower
				else if (mouseOver(hoverMX, hoverMY, 706, 309, 56, 56)) {
					handler.hoverUITower = 7;
				}
				// Rainbow Tower
				else if (mouseOver(hoverMX, hoverMY, 774, 309, 56, 56)) {
					handler.hoverUITower = 8;
				}
				else {
					handler.hoverUITower = 0;
				}
			}
			// If A Tower Was Just Purchased And Is Being Dragged To Be Placed Somewhere
			else if (towerInHand) {
				handler.mx = hoverMX;
				handler.my = hoverMY;
			}
		}
	}
	
	public void mousePressed(MouseEvent e) {
		// Mouse Coordinates
		int mx = e.getX();
		int my = e.getY();
		// Array Coordinates
		int row = my / 48;
		int col = mx / 48;
		// Map Coordinates
		int xPos = mx / 48 * 48;
		int yPos = my / 48 * 48;
		if (!handler.paused) {
			if (!towerInHand) {
				// Buy Red Tower
				if (mouseOver(mx, my, 706, 105, 56, 56)) {
					if (handler.getPlayer().getMoney() >= RedTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - RedTower.COST);
						handler.renderTowerInHand = 1;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = RedTower.COST;
						towerInHand = true;
					}
				}
				// Buy Orange Tower
				else if (mouseOver(mx, my, 774, 105, 56, 56)) {
					if (handler.getPlayer().getMoney() >= OrangeTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - OrangeTower.COST);
						handler.renderTowerInHand = 2;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = OrangeTower.COST;
						towerInHand = true;
					}
				}
				// Buy Yellow Tower
				else if (mouseOver(mx, my, 706, 173, 56, 56)) {
					if (handler.getPlayer().getMoney() >= YellowTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - YellowTower.COST);
						handler.renderTowerInHand = 3;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = YellowTower.COST;
						towerInHand = true;
					}
				}
				// Buy Green Tower
				else if (mouseOver(mx, my, 774, 173, 56, 56)) {
					if (handler.getPlayer().getMoney() >= GreenTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - GreenTower.COST);
						handler.renderTowerInHand = 4;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = GreenTower.COST;
						towerInHand = true;
					}
				}
				// Buy Blue Tower
				else if (mouseOver(mx, my, 706, 241, 56, 56)) {
					if (handler.getPlayer().getMoney() >= BlueTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - BlueTower.COST);
						handler.renderTowerInHand = 5;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = BlueTower.COST;
						towerInHand = true;
					}
				}
				// Buy Purple Tower
				else if (mouseOver(mx, my, 774, 241, 56, 56)) {
					if (handler.getPlayer().getMoney() >= PurpleTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - PurpleTower.COST);
						handler.renderTowerInHand = 6;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = PurpleTower.COST;
						towerInHand = true;
					}
				}
				// Buy Gray Tower
				else if (mouseOver(mx, my, 706, 309, 56, 56)) {
					if (handler.getPlayer().getMoney() >= GrayTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - GrayTower.COST);
						handler.renderTowerInHand = 7;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = GrayTower.COST;
						towerInHand = true;
					}
				}
				// Buy Rainbow Tower
				else if (mouseOver(mx, my, 774, 309, 56, 56)) {
					if (handler.getPlayer().getMoney() >= RainbowTower.COST) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - RainbowTower.COST);
						handler.renderTowerInHand = 8;
						handler.hoverUITower = 0;
						handler.selectedATower = false;
						handler.mx = mx;
						handler.my = my;
						refundableMoney = RainbowTower.COST;
						towerInHand = true;
					}
				}
				// Click Next Wave Or Wait
				else if (mouseOver(mx, my, 678, 544, 104, 24)) {
					if (handler.nextWaveAvailable && handler.getWaveManager().getWave() < 16) {
						handler.getWaveManager().nextWave();
						handler.nextWaveAvailable = false;
					}
				}
				// Click On Game Map
				else if (mx < 672) {
					// Click Path Tile Or Blank Tile
					if (handler.mapArray[row][col] == 9 || handler.mapArray[row][col] == 0) {
						handler.selectedATower = false;
					}
					else {
						handler.selectedATower = true;
						handler.mx = xPos;
						handler.my = yPos;
					}
				}
				// If Has Selected Tower And Click Upgrade
				else if (handler.selectedATower && mouseOver(mx, my, 684, 478, 64, 24)) {
					if (handler.getPlayer().getMoney() >= handler.tempTower.upgradeCost && handler.tempTower.upgradeCount < 5) {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() - handler.tempTower.upgradeCost);
						handler.tempTower.upgradeTower();
					}
				}
				// If Has Selected Tower And Click Sell
				else if (handler.selectedATower && mouseOver(mx, my, 788, 478, 64, 24)) {
					handler.getPlayer().setMoney(handler.getPlayer().getMoney() + handler.tempTower.sellPrice);
					handler.mapArray[handler.tempTower.getY() / 48][handler.tempTower.getX() / 48] = 0;
					handler.removeTower(handler.tempTower);
					handler.selectedATower = false;
				}
			}
			else if (towerInHand) {
				// Pressed On Game Map
				if (mx < 672) {
					// If Pressed On A Black Tile
					if (handler.mapArray[row][col] == 0) {
						// Red Tower
						if (handler.renderTowerInHand == 1) {
							handler.addTower(new RedTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 1;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Orange Tower
						else if (handler.renderTowerInHand == 2) {
							handler.addTower(new OrangeTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 2;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Yellow Tower
						else if (handler.renderTowerInHand == 3) {
							handler.addTower(new YellowTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 3;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Green Tower
						else if (handler.renderTowerInHand == 4) {
							handler.addTower(new GreenTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 4;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Blue Tower
						else if (handler.renderTowerInHand == 5) {
							handler.addTower(new BlueTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 5;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Purple Tower
						else if (handler.renderTowerInHand == 6) {
							handler.addTower(new PurpleTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 6;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Gray Tower
						else if (handler.renderTowerInHand == 7) {
							handler.addTower(new GrayTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 7;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						// Rainbow Tower
						else if (handler.renderTowerInHand == 8) {
							handler.addTower(new RainbowTower(handler, xPos, yPos));
							handler.mapArray[row][col] = 8;
							handler.selectedATower = true;
							handler.mx = xPos;
							handler.my = yPos;
						}
						refundableMoney = 0;
						handler.renderTowerInHand = 0;
						towerInHand = false;
					}
				}
				// Pressed On User Interface
				else if (mx >= 672) {
					// Can't Click On Next Wave Or Pause
					if (mouseOver(mx, my, 786, 544, 72, 24) ||
						mouseOver(mx, my, 678, 544, 104, 24)) {
						
					}
					else {
						handler.getPlayer().setMoney(handler.getPlayer().getMoney() + refundableMoney);
						refundableMoney = 0;
						handler.renderTowerInHand = 0;
						towerInHand = false;
					}
				}
			}
		}
		// Click Pause Or Resume
		if (mouseOver(mx, my, 786, 544, 72, 24) && !towerInHand) {
			if (!handler.paused) {
				handler.paused = true;
				handler.startPause = System.currentTimeMillis();
				handler.needsToSubtractPauseTime = true;
			}
			else if (handler.paused) {
				handler.paused = false;
				handler.endPause = System.currentTimeMillis();
			}
		}
	}
	
	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if (mx > x && mx < x + width && my > y && my < y + height)
			return true;
		return false;
	}
	
}
