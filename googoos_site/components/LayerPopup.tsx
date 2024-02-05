import { Actions, ActionsButton, ActionsGroup, ActionsLabel } from "konsta/react";

interface Props {
  opened: boolean;
  setOpened: (v: boolean) => void;
  onClick: () => void;
}

export default function LayerPopup({ opened, setOpened, onClick }: Props) {
  return (
    <Actions opened={opened} onBackdropClick={() => setOpened(false)}>
      <ActionsGroup>
        <ActionsLabel>변경사항을 적용하시겠습니까?</ActionsLabel>
        <ActionsButton onClick={onClick} bold>
          확인
        </ActionsButton>
        <ActionsButton onClick={() => setOpened(false)}>취소</ActionsButton>
      </ActionsGroup>
    </Actions>
  );
}
