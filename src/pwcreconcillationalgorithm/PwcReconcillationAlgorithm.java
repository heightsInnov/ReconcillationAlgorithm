/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pwcreconcillationalgorithm;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pwcreconcillationalgorithm.model.Excel;

/**
 *
 * @author aojinadu
 */
public class PwcReconcillationAlgorithm {

	/**
	 * @param args the command line arguments
	 */
	private static final String FILENAME_0 = "C:\\Users\\aojinadu\\Downloads\\PWC\\Reconcilition journal.txt";

	public static List<String> readFileInList(String fileName) {

		List<String> lines = Collections.emptyList();
		try {
			lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
		} catch (IOException e) {
		}
		return lines;
	}

	static List<TxtRecon> ConvertTxt() throws IOException {
		//Initial record list
		List<String> l = readFileInList(FILENAME_0);

		//Final Object list on filtering
		List<TxtRecon> tRec = new ArrayList();

		//List with no empty lines
		List<String> listed = new ArrayList();

		//Check for empty lines in the txt file
		l.stream().filter((s) -> (!s.equals(""))).forEachOrdered((s) -> {
			listed.add(s);
		});

		int i = 1;
		//Loop the record lines in batches
		TxtRecon d = new TxtRecon();
		for (String s : listed) {
			if (s.startsWith("***")) {
				String[] a = s.split("   ");
				if (a.length > 2) {
					d.setRrn(a[1]);
					d.setStan(a[2]);
				}
			} else if (s.startsWith("WITHDRAW")) {
				String[] a = s.split("          ");
				if (a.length > 1) {
					int aa = Math.round(Float.valueOf(a[1].replace("N", "").replace(" ", "")));
					d.setAmount(String.valueOf(aa));
				}
			}

			//check for begining of new record in txt file
			if (i % 15 == 0) {
				d = new TxtRecon();
				tRec.add(d);
			}
			i++;
		}
		return tRec;
	}

	public static void main(String[] args) {
		try {
			List<TxtRecon> reconList = ConvertTxt();
			List<Excel> excelList = NewExcel.Converter();
			int i = 1;
			for (TxtRecon r : reconList) {
				for (Excel e : excelList) {
					try {
						if (e.getStan() != null && r.getStan().trim().equals(e.getStan()) && r.getRrn().equals(e.getRrn()) && r.getAmount().equals(e.getAmount())) {
							System.out.println("Valid Record " + i + " >> " + r.getStan() + "->" + r.getRrn() + "->" + r.getAmount());
							i++;
						}
					} catch (NullPointerException ex) {

					}
				}
			}
		} catch (IOException ex) {
			Logger.getLogger(PwcReconcillationAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
		} catch (Exception ex) {
			Logger.getLogger(PwcReconcillationAlgorithm.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}

class TxtRecon extends Excel {
}
