import { Link, Navbar } from "konsta/react";
import { useRouter } from "next/router";
interface IconProps {
  onClick: () => void;
  title: string;
}

interface Props {
  title: string | undefined;
  subTitle: string | undefined;
  leftIcon?: IconProps | undefined;
  rightIcon?: IconProps | undefined;
}

const Header = ({ title, subTitle, leftIcon, rightIcon }: Props) => {
  const router = useRouter();

  return (
    <Navbar
      title={title}
      subtitle={subTitle}
      className="top-0 sticky"
      left={
        <Link navbar onClick={leftIcon?.onClick ? () => leftIcon.onClick() : () => router.back()}>
          <div>
            {leftIcon?.title ? (
              leftIcon?.title
            ) : (
              <div className="flex items-center">
                <LeftIcon />
                <p className="ml-1">뒤로</p>
              </div>
            )}
          </div>
        </Link>
      }
      right={
        rightIcon ? (
          <Link navbar onClick={rightIcon.onClick}>
            <p className="p-1">{rightIcon.title}</p>
          </Link>
        ) : (
          <></>
        )
      }
    />
  );
};

const LeftIcon = () => (
  <svg xmlns="http://www.w3.org/2000/svg" width="12" height="20" viewBox="0 0 12 20" fill="currentcolor">
    <path d="M0.18261596,9.4221638 C0.21783626,9.37068075 0.25835058,9.32165682 0.30416276,9.27584463 L9.1425872,0.4374202 C9.7256776,-0.14567018 10.6691555,-0.1475686 11.2590259,0.44230183 C11.8448123,1.02808827 11.8502479,1.97240019 11.2639075,2.55874056 L3.82594417,9.9967039 L11.2578297,17.4285894 C11.8409201,18.0116798 11.8428185,18.9551577 11.252948,19.5450281 C10.6671616,20.1308146 9.7228497,20.1362501 9.13650932,19.5499097 L0.2980849,10.7114853 C-0.0545897,10.3588107 -0.0959125,9.8144953 0.18261596,9.4221638 Z"></path>
  </svg>
);

export default Header;
