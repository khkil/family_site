import * as Hangul from "hangul-js";

// 초성검색
export const searchFirstLetter = (target: string, text: string) => {
  target = target.toUpperCase();
  text = text.toUpperCase();

  // separate if character at index is jong-sung
  for (let i = 0; i < text.length; i++) {
    if (Hangul.isJong(text[i])) {
      text = text.slice(0, i) + Hangul.d(text[i]).join("") + text.slice(i + 1);
    }
  }
  // disassembled array
  const dTarget: string[][] = Hangul.d(target, true);
  const dText: string[][] = Hangul.d(text, true);

  // cho-sung string for comparison
  const choTarget = dTarget.map((el) => el[0]).join("");
  const choText = dText.map((el) => el[0]).join("");
  let correctIdx = choTarget.indexOf(choText);
  let check = false;

  while (correctIdx >= 0) {
    check = true;

    for (let charIdx = 0; charIdx < dText.length; charIdx++) {
      const dTargetIdx = charIdx + correctIdx;

      for (let dIdx = 0; dIdx < dText[charIdx].length; dIdx++) {
        if (dTarget[dTargetIdx][dIdx] !== dText[charIdx][dIdx]) {
          check = false;
          if (
            dIdx === dText[charIdx].length - 1 &&
            Hangul.isCho(dText[charIdx][dIdx]) &&
            dTarget[dTargetIdx + 1] &&
            dTarget[dTargetIdx + 1][0] === dText[charIdx][dIdx]
          )
            check = true;
          break;
        }
      }

      if (check === false) {
        correctIdx = choTarget.indexOf(choText, correctIdx + 1);
        break;
      }
    }
    if (check) break;
  }

  return check;
};
