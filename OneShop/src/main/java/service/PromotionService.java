package service;

import java.util.List;

import dao.PromotionDAO;
import models.Promotion;

public interface PromotionService {

	void addPromotion(Promotion promotion);
	void updatePromotion(Promotion promotion);
	void deletePromotion(String promotionId);
	Promotion getPromotionById(String promotionId);
	List<Promotion> getAllPromotion(String userId);
}
