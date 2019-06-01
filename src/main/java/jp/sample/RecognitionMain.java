package jp.sample;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import javax.imageio.ImageIO;

import net.sourceforge.tess4j.ITessAPI.TessPageIteratorLevel;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.Word;

/**
 * HELLQと出力される
 *
 */
public class RecognitionMain {
	public static void main(String[] args) throws Exception {
		String path = "input\\sample.png";
		File target = new File(path);
		// ファイル読み込み
		BufferedImage image = ImageIO.read(target);

		ITesseract tess = new Tesseract();
		// 設定ファイル読み込み
		tess.setDatapath("Tess4J\\tessdata");
		// 対象の文字列の言語設定(ここではEnglish)
		tess.setLanguage("eng");
		// 読み取り
		String word = tess.doOCR(target);
		List<Word> words = tess.getWords(image, TessPageIteratorLevel.RIL_BLOCK);

		System.out.println(words);
		System.out.println(word);

	}
}
